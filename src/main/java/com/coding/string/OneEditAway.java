package com.coding.string;

/*
Leetcode: 72 Edit Distance
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */
public class OneEditAway {

  public static void main(String[] args) {
    System.out.println(oneEditAway("pale", "ple"));   // expect true (one insert away)
    System.out.println(oneEditAway("pales", "pale")); // expect true (one delete away)
    System.out.println(oneEditAway("pale", "bale"));  // expect true (one replace away)
    System.out.println(oneEditAway("pale", "bea"));   // expect false(more than one edit)

  }

  // Solution #1
  public static boolean oneEditAway(String str1, String str2) {
    // if the length is more than one edit, return false
    if (Math.abs(str1.length()-str2.length()) > 1) {
      return false;
    }

    // get shorter and longer string
    String s1 = str1.length() < str2.length() ? str1 : str2;
    String s2 = str1.length() < str2.length() ? str2 : str1;

    int index1 = 0, index2 = 0;
    boolean foundDifference = false;

    while (index2 < s2.length() && index1 < s1.length()) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if (foundDifference) {
          return false;
        }
        foundDifference = true;

        if (s1.length() == s2.length()) { // on replace, move shorter pointer
          index1++;
        }
      } else {
        index1++; // if matching, move shorter pointer
      }
      index2++; // always move pointer for longer string
    }
    return true;
  }

  // Solution #2
  public static boolean oneEditAway1(String first, String second) {
    if (first.length() == second.length()) {
      return oneEditReplace(first, second);
    } else if (first.length() + 1 == second.length()) {
      return oneEditInsert(first, second);
    } else if (first.length() - 1 == second.length()) {
      return oneEditInsert(second, first);
    }
    return false;
  }

  /* Check if you can replace a character into sl to make s2. */
  public static boolean oneEditReplace(String s1, String s2) {
    boolean foundDifference = false;
    for (int i=0; i<s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (foundDifference) {
          return false;
        }
        foundDifference = true;
      }
    }
    return true;
  }

  /* Check if you can insert a character into sl to make s2. */
  public static boolean oneEditInsert(String s1, String s2) {
    int index1 = 0;
    int index2 = 0;
    while (index1 < s1.length() && index2 < s2.length()) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if (index1 != index2) {
          return false;
        }
        index2++;
      } else {
        index1++;
        index2++;
      }
    }
    return true;
  }
}
