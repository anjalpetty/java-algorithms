package com.coding.slidingwindow;

import java.util.Arrays;

public class MedianSubArray {
  public static void main(String args[]) {
    System.out.println(Arrays.toString(medianSubArray(new int[]{1, 2, -1, 3, 5}, 2)));
  }

  public static double[] medianSubArray(int[] nums, int k) {
    double[] result = new double[nums.length-1];

    for (int i=0; i<nums.length-1; i++) {
      for (int j=i; j<i+k; j++)
      result[i] = (float)(nums[i] + nums[i+1])/(float)2;
    }
    return result;
  }
}
