package com.coding.arrays;

import java.util.Arrays;

/*

leetcode: 238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductArray {

  public static void main(String[] args) {
    int[] out1 = productExceptSelf(new int[]{1,2,3,4});
    System.out.println(Arrays.toString(out1));

//    int[] out2 = productExceptSelf(new int[]{-1,1,0,-3,3});
//    System.out.println(Arrays.toString(out2));
  }

  // O(n) memory - optimized
  public static int[] productExceptSelf(int[] nums) {

    int[] output = new int[nums.length];
    int prefix = 1;
    for (int i = 0; i < nums.length; i++) {
      output[i] = prefix;
      prefix *= nums[i];
    }

    int postfix = 1;
    for (int i=nums.length-1; i>=0; i--) {
      output[i] *= postfix;
      postfix *= nums[i];
    }
    return output;
  }

  // O(2n) memory
  public static int[] productExceptSelfBruteForce(int[] nums) {

    int[] prefix = new int[nums.length];
    int[] postfix = new int[nums.length];
    int[] output = new int[nums.length];
    for (int i=0; i<nums.length; i++) {
      if (i==0) {
        prefix[i] = 1;
      } else {
        prefix[i] = nums[i-1] * prefix[i-1];
      }
    }
    for (int i=nums.length-1; i>=0; i--) {
      if (i==nums.length-1) {
        postfix[i] = 1;
      } else {
        postfix[i] = postfix[i+1] * nums[i+1];
      }
    }

    for (int i=0; i<nums.length; i++) {
      output[i] = prefix[i] * postfix[i];
    }
    return output;
  }

}
