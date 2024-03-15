package com.coding.arrays;

import java.util.Arrays;

/**
 * Leetcode 66: Plus One
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith
 * digit of the integer. The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }

    public static int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] output = new int[digits.length+1];
        output[0] = 1;
        return output;
    }
}
