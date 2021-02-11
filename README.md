Text Processor contains code for PHASE-I and PHASE-II written in JAVA,    
whereas PHASE-III is written in Python using TCP server.  
# OVERVIEW #    
## PHASES-I,II: ##    
  **a)Features:**  
  1)Count the frequencies of all words in a text file and store them in a new file.  
  2)Output all words which appear in the input file starting with a given prefix with their word counts.    
  3)Has an option of ignoring case while computing 2.  
  **b)Command Line Interface:**  
  After building jar files from the project,  
  To start the command line program, execute the following command:  
          "java -jar Text-Processor.jar <options>"  
  **c)Options:**  
   -f path   The file or directory to search, default is null.  
   -p prefix The word with which the prefix words are to be calculated, default is null.  
   -i        Ignore case when searching for words, by default the search is case-sensitive.  
     
   		 Examples:  
     	-f input.txt -> to compute the occurrences of all words in input.txt file.  
     	-f input.txt -p cold -i -> to compute all words and their frequencies whose prefix is cold, ignoring Case.  
## PHASE-III: ##    
    In PHASE_III,a client will connect to it over some part where you can issue a command  
      a. count filename word,  
and the Server will respond with the answer. 
     
