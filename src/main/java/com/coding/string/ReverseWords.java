package com.coding.string;

/**
 * LeetCode: 151 reverse words in a string
 * reverse words in a sentence
 * input: the sky is blue
 * output: blue is sky the
 * <p>
 * input: "  hello world "
 * output: "world hello
 * note: reversed should not contain any leading or trailing spaces
 */
public class ReverseWords {

  public static void main(String[] args) {
    System.out.println("[" + reverseWords("the sky is blue") + "]");
    System.out.println("[" + reverseWords("  hello world ") + "]");
  }

  public static String reverseWords(String sentence) {
    String[] words = sentence.split("\\s+");
    String reversed = "";
    for (int i = words.length - 1; i >= 0; i--) {
      reversed = reversed + words[i] + " ";
    }
    return reversed.trim();
  }
}
