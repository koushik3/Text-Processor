import socket
import sys, pickle

# Create a TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = ('localhost', 8000)
print >>sys.stderr, 'connecting to %s port %s' % server_address
sock.connect(server_address)

try:
    command = str(raw_input("*** Command Syntax: count '<filename>' <word> *** \n"))
    command_list = command.split("'");
    command_list[0] = str(command_list[0]).strip()
    command_list[2] = str(command_list[2]).strip()

    for item in command_list:
    	print item

    # Send data
    message = pickle.dumps(command_list)
    sock.sendall(message)

    # Look for the response
    amount_received = 0
    amount_expected = len(message)
    
    data = sock.recv(4096)
    print "Word Count of " + command_list[2] + " is " + data
    
finally:
    print >>sys.stderr, 'closing socket'
    sock.close()
