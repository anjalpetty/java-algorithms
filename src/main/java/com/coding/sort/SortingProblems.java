package com.coding.sort;


import java.util.Arrays;
import java.util.Random;

public class SortingProblems {

  public static void main(String[] args) {

    int nums1[] = genNumbers(10);
    System.out.println("Before Quick sorting : " + Arrays.toString(nums1));
    quickSort(nums1, 0, nums1.length-1);
    System.out.println("After Quick sorting  : " + Arrays.toString(nums1));

    int nums2[] = genNumbers(5);
    System.out.println("Before merge sorting : " + Arrays.toString(nums2));
    mergeSort(nums2);
    System.out.println("After merge sorting  : " + Arrays.toString(nums2));

    int nums3[] = genNumbers(7);
    System.out.println("Before bubble sorting : " + Arrays.toString(nums3));
    bubbleSort(nums3);
    System.out.println("After bubble sorting  : " + Arrays.toString(nums3));
  }

  public static int[] genNumbers(int length) {
    Random random = new Random();
    int[] nums = new int[length];
    for (int i=0; i<nums.length; i++) {
      nums[i] = random.nextInt(100);
    }
    return nums;
  }

  public static void bubbleSort(int[] arr) {
    int length = arr.length;
    for (int i=0; i<length-1; i++) {
      for (int j=i+1; j<length; j++) {
        if (arr[i] > arr[j]) {
          swap(arr, i, j);
        }
      }
    }
  }

  public static void quickSort(int[] arr, int left, int right) {

    if (left >= right ) {
      return;
    }
    int pivot = arr[right];
    int leftPointer = partition(arr, left, right, pivot);
    quickSort(arr, left, leftPointer-1);
    quickSort(arr, leftPointer+1, right);
  }

  public static int partition(int[] arr, int left, int right, int pivot) {
    int leftPointer = left;
    int rightPointer = right;
    while (leftPointer < rightPointer) {
      while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
        leftPointer++;
      }
      while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
        rightPointer--;
      }

      swap(arr, leftPointer, rightPointer);
    }

    swap(arr, leftPointer, right);
    return leftPointer;
  }

  public static void mergeSort(int[] arr) {
    int length = arr.length;
    if (length < 2) {
      return;
    }
    int mid = length/2;
    int[] leftHalf = new int[mid];
    int[] rightHalf = new int[length-mid];

    for (int i=0; i<mid; i++) {
      leftHalf[i] = arr[i];
    }
    for (int j=mid; j<length; j++) {
      rightHalf[j - mid] = arr[j];
    }

    mergeSort(leftHalf);
    mergeSort(rightHalf);

    // merge
    merge(arr, leftHalf, rightHalf);
  }

  private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;

    int i=0, j=0, k=0;
    while (i < leftSize && j < rightSize) {
      if (leftHalf[i] <= rightHalf[j]) {
        arr[k++] = leftHalf[i++];
      } else {
        arr[k++] = rightHalf[j++];
      }
    }
    while (i < leftSize) {
      arr[k++] = leftHalf[i++];
    }
    while (j < rightSize) {
      arr[k++] = rightHalf[j++];
    }
  }

  public static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

}
