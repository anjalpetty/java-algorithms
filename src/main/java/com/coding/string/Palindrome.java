package com.coding.string;

public class Palindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("0P"));
    System.out.println(longestPalindrome("racecar"));
    System.out.println(countSubstringsOptimized("aaa"));
  }

  public static boolean isPalindrome(String s) {
    String cleaned = s
        .replaceAll("[^a-zA-Z]", " ")
        .toLowerCase()
        .replaceAll("\\s+", "");

    int l=0;
    int r=cleaned.length()-1;
    while (l <= r) {
      if (cleaned.charAt(l) == cleaned.charAt(r)) {
        l++; r--;
      } else {
        return false;
      }
    }
    return true;
  }

  public static String longestPalindrome(String s) {

    if (s.isEmpty()) {
      return s;
    }
    int start = 0;
    int end = 0;
    for (int i=0; i<s.length(); i++) {
      int len1 = expandFromMiddle(s, i, i);
      int len2 = expandFromMiddle(s, i, i+1);
      int len = Math.max(len1, len2);
      if (len > end-start) {
        start = i - ((len-1)/2);
        end = i + (len/2);
      }
    }
    return s.substring(start, end+1);
  }

  private static int expandFromMiddle(String s, int l, int r) {
    while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
    }
    return r - l - 1;
  }

  // optimized
  public static int countSubstringsOptimized(String s) {

    int count =0;

    for (int i=0; i<s.length(); i++) {
      int l=i;
      int r=i;
      while (l>=0 && r< s.length() && s.charAt(l) == s.charAt(r)) {
        count++;
        l--;
        r++;
      }
      l=i;
      r=i+1;
      while (l>=0 && r< s.length() && s.charAt(l) == s.charAt(r)) {
        count++;
        l--;
        r++;
      }
    }
    return count;
  }

  // brute-force
  public static int countSubstrings(String s) {

    int count =0;
    int pos=0;
    for (int i=0; i<s.length(); i++) {
      int j=0;
      while (j <=i) {
        String sub = s.substring(pos, j+1);
        if (isPalindrom(sub)) {
          count++;
        } else {
          if (i > 1) pos++;
        }
        j++;
      }
    }
    return count;
  }

  public static boolean isPalindrom(String s) {
    int l=0;
    int r=s.length()-1;

    while (l<=r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++; r--;
    }
    return true;
  }

}
