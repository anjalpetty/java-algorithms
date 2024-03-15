package com.coding.binary;

import java.util.Arrays;

public class BinaryProblems {

  public static void main(String[] args) {
    System.out.println(">> sum of two:" + twoSum(1, 2));
    System.out.println(">> number of digits: " + hammingWeight(7));
    System.out.println(">> counting bits   : " + Arrays.toString(countBits(2)));
    System.out.println(">> missing number  : " + missingNumber(new int[]{0, 1}));
    System.out.println(">> reverse bits    : " + reverseBits(4));
  }

  // leetcode 371. Sum of Two Integers
  // return sum of two numbers without using + or -
  public static int twoSum(int a, int b) {
    while (b != 0) {
      int carry = (a & b) << 1;
      a = a ^ b;
      b = carry;
    }
    return a;
  }

  // leetcode 191. Number of 1 Bits
  // returns the number of '1' bits it has (also known as the Hamming weight).
  // you need to treat n as an unsigned value
  public static int hammingWeight(int n) {
    int digits = 0;
    while (n != 0) {
      digits ++;
      n &= (n - 1);
    }
    return digits;
  }

  // leetcode 338. Counting Bits
  // Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
  // ans[i] is the number of 1's in the binary representation of i.
  public static int[] countBits(int n) {
    int output[] = new int[n+1];
    for (int i=0; i<=n; i++) {
      if (i%2 == 0) {
        output[i] = output[i/2];
      } else {
        output[i] = output[i/2] + 1;
      }
    }
    return output;
  }

  // leetcode 268. Missing Number
  // Given an array nums containing n distinct numbers in the range [0, n],
  // return the only number in the range that is missing from the array.
  public static int missingNumber(int[] nums) {

    int sum=nums.length;
    for (int i=0; i<nums.length; i++) {
      sum ^= i^ nums[i];
    }
    return sum;
  }

  // leetcode 190. Reverse Bits
  // Reverse bits of a given 32 bits unsigned integer.
  public static int reverseBits(int n) {
    int result = 0;
    for (int i=0; i<32; i++) {
      result <<=1;
      if ((n & 1) == 1) {
        result++;
      }
      n >>=1;
    }
    return result;
  }

  // binary to decimal
  public static int bin2Dec(int num) {
    int decimal = 0;
    int n=0;
    while (num > 0) {
      decimal += (num % 10) * (int)Math.pow(2, n);
      num = num / 10;
      n++;
    }
    return decimal;
  }

}
