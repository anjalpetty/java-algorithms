package com.coding.slidingwindow;

import java.util.Collection;
import java.util.HashSet;

/*
  leetcode: 3. Longest Substring Without Repeating Characters
  Given a string s, find the length of the longest substring without repeating characters.
  Input: s = "abcabcbb"
  Output: 3

  Input: s = "bbbbb"
  Output: 1

  Input: s = "pwwkew"
  Output: 3
*/
public class LongestSubString {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("bbbbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
    System.out.println(lengthOfLongestSubstring("aab"));
  }

  public static int lengthOfLongestSubstring(String s) {
    int max=0;
    int reset=0;
    int i=0;
    HashSet<Character> set = new HashSet<>();

    while (i<s.length()) {
      if (!set.contains(s.charAt(i))) {
        set.add(s.charAt(i));
        max = Math.max(set.size(), max);
        i++;
      } else {
        set.remove(s.charAt(reset));
        reset++;
      }
    }
    return max;
  }

}
