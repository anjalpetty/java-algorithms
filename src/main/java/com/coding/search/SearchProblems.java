package com.coding.search;

public class SearchProblems {

  public static void main(String[] args) {
    int[] arr = {9, 12, 23, 29, 54, 67, 76, 86, 90};
    int target = 90;

    System.out.println(binSearch(arr, target));
    System.out.println(binSearch(arr, target, 0, arr.length-1));

  }

  public static boolean binSearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length-1;
    int mid = (low + (high - low)/2);
    boolean found = false;
    while (low <= high) {
      mid = (low + high)/2;
      if ( target == arr[mid]) {
        found = true;
        break;
      } else if (target > arr[mid]) {
        low = mid+1;
      } else if (target < arr[mid]) {
        high = mid-1;
      }
    }

    return found;
  }

  // recursive
  public static boolean binSearch(int[] arr, int target, int low, int high) {
    int mid = low + ((high-low)/2);
    if (high < low) {
      return false;
    }

    if (target == arr[mid]) {
      return true;
    } else if (target < arr[mid]) {
      return binSearch(arr, target, low, mid-1);
    }
    return binSearch(arr, target, mid+1, high);
  }

}
