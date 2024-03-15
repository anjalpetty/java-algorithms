package com.coding.arrays;

import com.coding.sort.SortingProblems;

import java.util.Arrays;

public class KthLargest {

  // method-01: sort, return k-1 element
  public static int kthLargest(int[] arr, int k) {
//    SortingProblems.mergeSort(arr);
    SortingProblems.quickSort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
    return arr[k-1];
  }

  public static void main(String[] args) {
    // 0 1 2 5 7 8 9
    int[] arr = {5, 2, 7, 8, 1, 0, 9};

    System.out.println("method 01:" + kthLargest(arr, 4));
  }
}
