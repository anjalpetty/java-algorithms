package com.coding.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2blc5a3.
If the "compressed" string would not become smaller than the original string, your method should return
the original string.
You can assume the string has only uppercase and lowercase letters (a - z).*/

public class Compress {

  public static void main(String[] args) {
    System.out.println(compress("aabcccccaaa"));
  }

  public static String compress(String s) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i=0; i< s.length(); i++) {
      countConsecutive++;
      if (i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
        compressed.append(s.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    if (compressed.toString().length() > s.length()) {
      return s;
    }
    return compressed.toString();
  }
}
