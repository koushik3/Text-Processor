import socket
import sys, pickle
import wordcount as wc
from collections import Counter
from string import punctuation
import re	

def wordcount(filename,word):
	f = open(filename, "r")
	r = re.compile(r'[\s{}]+'.format(re.escape(punctuation)))
	c = Counter()
	for line in f:
		c += Counter( (r.split(line)) ) 
	f.close()
	return c[word]


# Create a TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind the socket to the port
server_address = ('localhost', 8000)
print >>sys.stderr, 'starting up on %s port %s' % server_address
sock.bind(server_address)

# Listen for incoming connections
sock.listen(1)

while True:
    # Wait for a connection
    print >>sys.stderr, 'waiting for a connection'
    connection, client_address = sock.accept()

    try:
        print >>sys.stderr, 'connection from', client_address

        # Receive the data in small chunks and retransmit it
        while True:
        	data = connection.recv(4096)
        	if data:
        		command_list = pickle.loads(data)
        		wordc = wc.wordcount(command_list[1], command_list[2])
        		print "Word Count of " + command_list[2] + " is " + str(wordc)
        		connection.sendall(str(wordc))
        	else:
        		print "No data from " + str(client_address)
        		break
            
    finally:
        # Clean up the connection
        connection.close()

