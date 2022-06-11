package com.javacc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(getLastWordLength(s));
    }

    public static int getLastWordLength(String words){
       int lastSpace =  words.lastIndexOf(" ");
       if(lastSpace>0){
          String lastWord = words.substring(lastSpace,words.length());
          if(lastWord != null && lastWord.length()>0){
             return lastWord.length();
          }else {
              return getLastWordLength(words.substring(0,lastSpace));
          }
       }else{
           return words.length();
       }
    }


}
