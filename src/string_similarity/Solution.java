/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package string_similarity;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author workhorse
 */
public class Solution {

    static String[] strings;
    static int score = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        java.io.File file = new java.io.File("input00.txt");
        
        try {
            Scanner input = new Scanner(file);
            
            int counter = 0;
            while(input.hasNext()) {
                
                String num = input.nextLine();
                
                if (counter == 0) {
                    strings = new String[Integer.parseInt(num)];
                } else {
                    strings[counter - 1] = num.toString();
                }
                
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.err.format("File does not exist\n");
        }
        
        for(int i = 0; i < strings.length; i++) {
            score = 0;
            permuteString(strings[i], strings[i]);
        }
    }
    
    public static void permuteString(String orig_string, String string) {
        if (string.length() == 0) {
            System.out.println(score);
        } else {
            boolean string_persist = true;
            for(int i = 0; i < orig_string.length(); i++) {
                if (i < string.length() && string_persist) {
                    if (orig_string.charAt(i) == string.charAt(i)) {
                        score++;
                    } else {
                        string_persist = false;
                    }
                }
            }
            
            permuteString(orig_string, string.substring(1, string.length()));
        }
    }
}
