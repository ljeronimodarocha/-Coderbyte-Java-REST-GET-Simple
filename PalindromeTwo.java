/*
Palindrome Two
Have the function PalindromeTwo(str) take the str parameter being passed and return the string true if the parameter is a palindrome, 
(the string is the same forward as it is backward) otherwise return the string false. The parameter entered may have punctuation and 
symbols but they should not affect whether the string is in fact a palindrome. For example: "Anne, I vote more cars race Rome-to-Vienna" 
should return true.
 */

import java.util.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
   public static boolean PalindromeTwo(String str) {
    String alphanumericStr = str.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
    
    return alphanumericStr.equals(new StringBuilder(alphanumericStr).reverse().toString());
}


    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(PalindromeTwo(s.nextLine()));
    }
}
