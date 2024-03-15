package com.coding.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanConvert {

  public static void main(String[] args) {
    System.out.println("intToRoman (1994): " + intToRoman(1994));
    System.out.println("romanToInt (MCMXCIV): " + romanToInt("MCMXCIV"));
    System.out.println("romanToInt (CMXCVIII): " + romanToInt("CMXCVIII"));
  }

  /*
   Leetcode: 12. Integer to Roman
   Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
  
      Symbol       Value
      I             1
      V             5
      X             10
      L             50
      C             100
      D             500
      M             1000
    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII,
    which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
    
    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
    Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    
    There are six instances where subtraction is used:
    
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given an integer, convert it to a roman numeral.
    
    Example 1:
    Input: num = 3
    Output: "III" (Explanation: 3 is represented as 3 ones.)
    
    Example 2:
    Input: num = 58
    Output: "LVIII" (Explanation: L = 50, V = 5, III = 3.)
    Example 3:
    
    Input: num = 1994
    Output: "MCMXCIV" (Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.)
  */
  public static String intToRoman(int num) {
    int[] intCode = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    // note: use of linked hash map is import as order is important here
    LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>() {{
      put(1000, "M");
      put(900, "CM");
      put(500, "D");
      put(400, "CD");
      put(100, "C");
      put(90, "XC");
      put(50, "L");
      put(40, "XL");
      put(10, "X");
      put(9, "IX");
      put(5, "V");
      put(4, "IV");
      put(1, "I");
    }};
    StringBuilder builder = new StringBuilder();
        /*for (int i=0; i<intCode.length; i++) {
            int count = num / intCode[i];
            while (count-- > 0) {
                builder.append(code[i]);
            }
            num %= intCode[i];
        }*/
    for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
      int count = num / entry.getKey();
      while (count-- > 0) {
        builder.append(entry.getValue());
      }
      num %= entry.getKey();
    }
    return builder.toString();
  }

  /**
   * LeetCode: 13 Roman to Int
   * Iterate each character and check if the numeric value is greater or lesser than next
   * if greater, then add; otherwise subtract.
   */
  public static int romanToInt(String roman) {
    LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>() {{
      put("M", 1000);
      put("D", 500);
      put("C", 100);
      put("L", 50);
      put("X", 10);
      put("V", 5);
      put("I", 1);
    }};
    int number = 0;
    // MCMXCIV
    for (int i=0; i<roman.length(); i++) {
      if (i+1 < roman.length() && hashMap.containsKey(String.valueOf(roman.charAt(i)))) {
        if (hashMap.get(String.valueOf(roman.charAt(i))) >= hashMap.get(String.valueOf(roman.charAt(i+1)))) {
          number += hashMap.get(String.valueOf(roman.charAt(i)));
        } else {
          number -= hashMap.get(String.valueOf(roman.charAt(i)));
        }
      } else {
        number += hashMap.get(String.valueOf(roman.charAt(i)));
      }
    }
    return number;
  }
}
