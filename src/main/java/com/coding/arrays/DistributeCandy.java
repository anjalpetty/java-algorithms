package com.coding.arrays;

import java.util.Arrays;

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.

e.g: input [1, 2]
     output 3 (1+2)

     input [1, 5, 2, 1]
     output 7 (1 + 3 + 2 + 1)

     input [7, 3, 1, 5, 3]
     output 9 (3 + 2 + 1 + 2 + 1)
 */
public class DistributeCandy {

  public static void main(String[] args) {
    System.out.println("Candies required: " + candy(new int[]{1, 3, 2}));
    System.out.println("Candies required: " + candy(new int[]{1, 5, 2, 1}));
    System.out.println("Candies required: " + candy(new int[]{7, 3, 1, 5, 3}));
    System.out.println("Candies required: " + candy(new int[]{1, 2, 6, 5, 4, 3, 1}));
  }

  public static int candy(int[] arr) {

    int size = arr.length;
    int[] leftRating = new int[size];
    int[] rightRating = new int[size];

    int i;
    leftRating[0] = 1;
    for (i=1; i<size; i++) {
      if (arr[i] > arr[i-1]) {
        leftRating[i] = leftRating[i-1] + 1;
      } else {
        leftRating[i] = 1;
      }
    }

    rightRating[size-1] = 1;
    for (i=size-1;i>0;i--) {
      if (arr[i-1] > arr[i]) {
        rightRating[i-1] = rightRating[i] +1;
      } else {
        rightRating[i-1] = 1;
      }
    }

    System.out.println(Arrays.toString(leftRating));
    System.out.println(Arrays.toString(rightRating));
    int totalCandies = 0;
    for (i=0; i<size; i++) {
      totalCandies = totalCandies + Math.max(leftRating[i], rightRating[i]);
    }
    return totalCandies;
  }

}
