package com.coding.string;

/*
 leetcode 1189: Maximum number of Balloons
 Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

 You can use each character in text at most once. Return the maximum number of instances that can be formed.
 */
public class BalloonMax {

  public static void main(String[] args) {
    System.out.println(maxNumberOfBalloons("nlaebolko"));
    System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    System.out.println(maxNumberOfBalloons("leetcode"));
  }

  // Time: O(N), Space: O(1)
  public static int maxNumberOfBalloons(String text) {
    int[] count = new int[26];
    for (int i=0; i<text.length(); i++) {
      count[text.charAt(i) -'a']++;
    }

    int min = count[1]; // b
    min = Math.min(min, count[0]); // a
    min = Math.min(min, count[11]/2); // l
    min = Math.min(min, count[14]/2); // o
    min = Math.min(min, count[13]); // n

    return min;
  }
}
