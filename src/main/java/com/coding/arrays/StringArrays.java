package com.coding.arrays;

public class StringArrays {

  public static void main(String[] args) {
    anagram("123", "");
    anagram("eat", 0, "eat".length() - 1);

    System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
  }

  //  eat, aet, ate, aet, eta, tea
  // method-01
  public static void anagram(String str, String anag) {

    if (str.length() == 0) {
      System.out.println(anag + " ");
      return;
    }
    for (int i=0; i< str.length(); i++) {
      char ch = str.charAt(i);
      String temp = str.substring(0, i) + str.substring(i+1);

      anagram(temp, anag + ch);
    }
  }

  // method-02
  public static void anagram(String str, int start, int end) {
    if (start == end) {
      System.out.println(str);
    }
    else {
      for (int i = start; i <= end; i++) {
        str = swap(str, start, i);
        anagram(str, start + 1, end);
        str = swap(str, start, i);
      }
    }
  }
  private static String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }

  /**
   * leetcode: 58: Length of last word
   * Given a string s consisting of words and spaces, return the length of the last word in the string.
   *
   * A word is a maximal substring consisting of non-space characters only.
   * @param s
   * @return
   */
  public static int lengthOfLastWord(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int len=0;
    char[] arr = s.toCharArray();
    for (int i=arr.length-1; i>=0; i--) {
      if (arr[i] == ' ') {
        if (len == 0) {
          continue;
        }
        return len;
      }
      len++;
    }
    return len;
  }

}
