/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textprocessor;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kholu
 */
public class TextProcessorTest {
    public static void main(String[] args) {
        if (args.length > 0) {
            String filename = null;
            String prefix = null;
            boolean ignore = false;
            for(int i=0;i<args.length;i++){
                switch (args[i]) {
                    case "-f":
                        if(i<args.length-1){
                            filename = args[++i];
                        }else{
                            System.out.println("Invalid input format");
                        }   break;
                    case "-p":
                        if(i<args.length-1){
                            prefix = args[++i];
                        }else{
                            System.out.println("Invalid input format");
                        }   break;
                    case "-i":
                        ignore = true;
                        break;
                    default:
                        break;
                }
            }
            TextProcessor tprocessor = new TextProcessor();
            try{
                if(filename!=null){
                    if(prefix!=null){
                        tprocessor.prefixCounter(filename,prefix,ignore);	
                    }else{
                        tprocessor.wordCounter(filename);
                        }
    			}
            }
            catch(IOException e){
                System.out.println("IOEXception!!");
            }
    	 }
    }
}
