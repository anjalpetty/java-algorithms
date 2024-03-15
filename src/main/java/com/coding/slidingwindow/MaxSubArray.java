package com.coding.slidingwindow;

/*
  Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
  Input: [2, 1, 5, 1, 3, 2], k=3
  Output: 9
  Explanation: Subarray with maximum sum is [5, 1, 3].

  Input: [2, 3, 4, 1, 5], k=2
  Output: 7
  Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSubArray {
  public static void main(String[] args) {
    System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
    System.out.println(findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
  }

  // sliding window approach. For each slide, remove first and add last element
  // time complexity O(n)
  public static int findMaxSumSubArray(int k, int[] arr) {

    int maxSum = 0;
    int windowStart = 0;
    int windowSum = 0;
    for (int windowEnd = 0; windowEnd<arr.length; windowEnd++) {
      windowSum += arr[windowEnd];

      if (windowEnd>=k) {
        windowSum -= arr[windowStart++];
      }
      maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
  }

  // brute-force approach
  // time complexity O(n * k)
  public static int findMaxSumSubArray2(int k, int[] arr) {
    // TODO: Write your code here
    int maxSum = 0;
    for (int i=0; i<=arr.length-k; i++) {
      int windowSum = 0;
      for (int j=i; j<i+k; j++) {
        windowSum += arr[j];
      }
      maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
  }

}
