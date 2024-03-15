package com.coding.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leetcode: 17. Letter Combinations of a Phone Number
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.
 */
public class PhoneNumber {

  public static void main(String[] args) {
    List<String> combinations = letterCombinations("23");
    for (String combination : combinations) {
      System.out.println(combination);
    }
  }

  static Map<String, String> hashMap = new HashMap<>() {{
    put("0", "0");
    put("1", "1");
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};
  public static List<String> letterCombinations(String digits) {

    List<String> result = new ArrayList<>();
    if (digits == null || digits.isEmpty()) {
      return result;
    }

    backtrack(digits, 0, result, new StringBuilder());

    return result;
  }

  public static void backtrack(String digits, int index, List<String> result, StringBuilder sb) {
    if (index == digits.length()) {
      result.add(sb.toString());
      return;
    } else {
      String digit = digits.substring(index, index+1);
      for (char c: hashMap.get(digit).toCharArray()) {
        sb.append(c);
        backtrack(digits, index+1, result, sb);
        sb.setLength(sb.length()-1);
      }
    }
  }
}
