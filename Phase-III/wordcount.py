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

#print wordcount("","")
