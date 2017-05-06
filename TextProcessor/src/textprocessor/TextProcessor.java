/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textprocessor;
import java.util.Scanner;
import java.io.*;
import java.util.Map;
import java.util.HashMap;    

/**
 *
 * @author kholu
 */
public class TextProcessor {
    public void wordCounter(String filename) throws IOException{ 
	Map<String, Integer> countByWords = new HashMap<String, Integer>();
    	Scanner s = null;
        s = new Scanner(new BufferedReader(new FileReader(filename)));
        while (s.hasNext()) {
            String next = s.next();
            String[] Res = next.split("[\\p{Punct}\\s^((\r\n)|(\n))]+");
            for (String word:Res){
                Integer count = countByWords.get(word);
                if (count != null) {
                    countByWords.put(word, count + 1);
                } else {
                    countByWords.put(word, 1);
                    }
            }
        }
        if(s != null) {
            s.close();
        }
       
        for(Map.Entry<String, Integer> entry : countByWords.entrySet()){    
            String word=entry.getKey();  
            Integer count=entry.getValue();  
            System.out.println(word+" , "+count);  
        }
    }
    
    public void prefixCounter(String filename , String prefix,boolean ignore) throws IOException{
        Map<String, Integer> countByWords = new HashMap<String, Integer>();
    	Scanner s = null;
        s = new Scanner(new BufferedReader(new FileReader(filename)));
        while (s.hasNext()) {
            String next = s.next();
            String[] Res = next.split("[\\p{Punct}\\s^((\r\n)|(\n))]+");
            if(ignore){ prefix = prefix.toLowerCase();}
            for (String word:Res){
                if(ignore){ word = word.toLowerCase();}
                if(word.startsWith(prefix)){
                    Integer count = countByWords.get(word);
                    if (count != null) {
                        countByWords.put(word, count + 1);
                    } else {
    		    	countByWords.put(word, 1);
                        }
                }
            }
        }
        if(s != null) {
            s.close();
        }
       
        for(Map.Entry<String, Integer> entry : countByWords.entrySet()){    
            String word=entry.getKey();  
            Integer count=entry.getValue();  
            System.out.println(word+" , "+count);  
        }
    }
}
