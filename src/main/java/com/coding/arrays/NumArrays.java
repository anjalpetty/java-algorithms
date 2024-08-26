package com.coding.arrays;

import java.util.*;

public class NumArrays {

  public static void main(String[] args) {
    System.out.println(">> sum of two array elements matching to target");
    twoSum(new int[]{8, 9, 5, 1, 0, 4, 7}, 12);

    System.out.println(">> sum of two sorted array elements matching to target");
    twoSumII(new int[]{1, 3, 4, 5, 7, 10, 11}, 9);

    System.out.println("maxProfit: " + maxProfit(new int[]{7, 6, 4, 3,1}));

    System.out.println(">> sort in-place");
    sortInPlace();

    System.out.println(">> max product of first two array elements");
    maxProductPair();

    System.out.println(">> move zeros to right");
    moveZerosToRight();

    System.out.println(">> max sub array:" + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.out.println(">> max prod sub array:" + maxProduct(new int[]{2,3,-2,4}));

    System.out.println(">> min in rotated sorted array: " + findMin(new int[]{11,13,15,17}));

    System.out.println(">> threeSum: " + threeSum(new int[]{-1,0,1,2,-1,-4}));

    System.out.println(">> rotate count");
    rotateCount();

    System.out.println(">> find pair");
    findPair(new int[]{2, 5, 5, 5, 6, 6, 8, 9, 9, 9}, 5);

    System.out.println(">> rotate an array k positions");
    rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3);

    System.out.println(">> merge two sorted arrays (no extra space)");
    int[] arr = mergeSortedArraysInPlace(new int[]{0, 1, 2, 2, 0, 0, 0}, new int[]{2, 5, 6});
    System.out.println(Arrays.toString(arr));

    System.out.println(">> merge two sorted arrays");
    arr = mergeSortedArrays(new int[]{0, 1, 3, 4, 8, 9}, new int[]{2, 5, 6, 7});
    System.out.println(Arrays.toString(arr));

    System.out.println(">> merge k sorted arrays (divide and conquer)");
    int[][] input = new int[][]{{0, 1, 2, 8, 9}, {3, 5, 7}, {4, 6}};
    arr = mergeKSortedArrays(input, 0, input.length-1);
    System.out.println(Arrays.toString(arr));

    System.out.println(">> merge k sorted arrays (using minheap priorityQueue)");
    arr = mergeKSortedArrays(input);
    System.out.println(Arrays.toString(arr));
  }

  // complexity: n
  // find the sum of first two numbers matching to given target
  public static void twoSum(int[] arr, int target) {

    Map<Integer, Integer> hash = new HashMap<>();
    for (int i=0; i< arr.length; i++) {
      int value = target - arr[i];
      if (hash.containsValue(value)) {
        System.out.println(arr[i] + ", " + value);
        return;
      } else {
        hash.put(arr[i], arr[i]);
      }
    }
  }

  // complexity n^2
  int[] twoSumN(int[] nums, int target) {
    int i=0; int j=1;
    int found=0;
    int[] a = new int[2];
    for (;i<nums.length-1;i++) {
      j=i+1;
      for (;j<nums.length;j++) {
        if (nums[i] + nums[j] == target) {
          found=1;
          break;
        }
      }
      if (found==1) {
        break;
      }
    }
    if (found==1) {
      a[0] = i; a[1] = j;
    }
    return a;
  }

  // Leetcode: 167
  // find the indices of two numbers add up to a target
  // given array is sorted in ascending order
  // NOTE: the array is sorted in ascending order
  // this differs from above approach
  public static void twoSumII(int[] arr, int target) {
    int left=0;
    int right=arr.length-1;

    while (left < right) {
      int sum = arr[left] + arr[right];
      if (sum > target) {
        right --;
      } else if (sum < target) {
        left ++;
      } else {
        System.out.println("indices adding to target sum are " + left + ", " + right);
        break;
      }
    }
  }

  /*
   leetcode 15. 3Sum
   Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
   and nums[i] + nums[j] + nums[k] == 0.

   Notice that the solution set must not contain duplicate triplets.
   */
  public static List<List<Integer>> threeSum(int[] nums) {

    // pick one index and consider remaining as two sum problem, continue to the rest.
    Set<List<Integer>> hash = new HashSet<>(); // this is important to avoid duplicate triplets
    Arrays.sort(nums);
    for (int i=0; i<nums.length-2; i++) {
      int left = i+1;
      int right = nums.length-1;
      while (left < right) {
        int threeSum = nums[i] + nums[left] + nums[right];
        if (threeSum == 0) {
          hash.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left ++; right --;
        } else if (threeSum > 0) {
          right--;
        } else if (threeSum < 0) {
          left++;
        }
      }
    }
    return new ArrayList<>(hash);
  }

  // leetcode 121. best time to buy and sell stock
  // return maximum profit, return 0 otherwise.
  public static int maxProfit(int[] prices) {
    int buy = prices[0];

    int profit = 0;
    for (int i=1; i<prices.length; i++) {
      if (prices[i] < buy) {
        buy = prices[i];
        continue;
      }
      if (prices[i]-buy > profit) {
        profit = prices[i]-buy;
      }
    }
    return profit;
  }

  // in-place sort in linear-time, constant space
  public static void sortInPlace() {
    int[] arr = {8, 9, 5, 1, 0, 4, 7};

    int i=0;
    int n = arr.length-1;
    for (;i<n;) {
      if (arr[i] > arr[i+1]) {
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
      }
      i++;
      if (i == n) {
        n--;
        i=0;
      }
    }

    for (i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("");
  }

  // find max product of first two array elements
  // step-01: find the max product value
  // step-02: find the elements matching to max value
  public static void maxProductPair() {
//    int[] arr = {-4, 3, 2, 7, -5};
    int[] arr = {-10, -3, 5, 6, -2};
    int i, j;
    int max=0;
    boolean flag = false;
    for (i=0; i<arr.length-1; i++) {
      for (j=i+1; j<arr.length; j++ ) {
        int p = arr[i] * arr[j];
        if ( p > max) {
          max = p;
          flag = true;
        }
      }
    }
    if (!flag && arr.length > 0) {
      max = arr[0];
    }
    // we know max value know
    System.out.println("max value: " + max);

    for (i=0; i<arr.length-1; i++) {
      for (j=i+1; j<arr.length; j++ ) {
        if ((arr[i] * arr[j]) == max) {
          System.out.println(arr[i] + ", " + arr[j]);
          break;
        }
      }
    }
  }

  /*
  Given an integer array, move all zeros present in it to the end. The solution should maintain the relative order of items in the array and should not use constant space.
  Input : [6, 0, 8, 2, 3, 0, 4, 0, 1]
  Output: [6, 8, 2, 3, 4, 1, 0, 0, 0]
   */
  public static void moveZerosToRight() {
    int nums[] = {6, 0, 8, 2, 3, 0, 4, 0, 1};
    for (int i=0; i<nums.length; i++) {
      for (int j=i+1; j<nums.length-1; j++) {
        if (nums[j] == 0) {
          int temp = nums[j];
          nums[j] = nums[j+1];
          nums[j+1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(nums));
  }

  // leetcode 152. Maximum Product Subarray
  public static int maxProduct(int[] nums) {
    int maxProd = nums[0];
    int maxEnding = nums[0];
    int minEnding = nums[0];

    for (int i=1; i<nums.length; i++) {
      int tmp = maxEnding;
      maxEnding = Math.max(nums[i], Math.max(nums[i] * maxEnding, nums[i] * minEnding));
      minEnding = Math.min(nums[i], Math.min(nums[i] * minEnding, nums[i] * tmp));

      maxProd = Math.max(maxProd, maxEnding);
    }
    return maxProd;
  }

  // leetcode 53. Maximum Subarray
  public static int maxSubArray(int[] nums) {
    int maxSub = nums[0];
    int curSum = 0;

    for (int i=0; i<nums.length; i++) {
      if (curSum < 0) {
        curSum = 0;
      }
      curSum += nums[i];
      maxSub = Math.max(maxSub, curSum);
    }
    return maxSub;
  }

  // continuous max sub array
  public static void maxSubArrayN() {
    int nums[] = {-2, 2, -1, 2, 1, 6, -10, 6, 4, -8};
    int max = nums[0];
    int n = nums.length;
    for (int i=0; i< n-1; i++) {
      int sum = nums[i];
      for (int j=i+1; j<n; j++) {
        sum = sum + nums[j];
        if (sum > max) {
          max = sum;
        } else {
          break;
        }
      }
      if (nums[i] > max) {
        max = nums[i];
      }
      System.out.println("sum: " + sum);
    }
    System.out.println("max: " + max);
  }

  /**
   Leetcode: 153. Find Minimum in Rotated Sorted Array
   find minimum in O(log n) times in a rotated sorted array
   Input: nums = [3,4,5,1,2]
   Output: 1
   Explanation: The original array was [1,2,3,4,5] rotated 3 times.

   Input: nums = [4,5,6,7,0,1,2]
   Output: 0
   Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
   * */
  public static int findMin(int[] nums) {
    int min = nums[0];

    int left = 0;
    int right = nums.length-1;

    while (left < right) {
      if (nums[left] > nums[right]) {
        left = (right+left)/2;
      } else if (nums[left] < nums[right]) {
        right = (right+left)/2;
      }
      if (nums[left] < min) {
        min = nums[left];
      }
    }
    return min;
  }

  // leetcode: 33. Search in Rotated Sorted Array
  // There is an integer array nums sorted in ascending order (with distinct values).
  // Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
  // Given the array nums after the possible rotation and an integer target, return the index of target if it is in
  // nums, or -1 if it is not in nums.
  //You must write an algorithm with O(log n) runtime complexity.
  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;

    while (left < right) {
      int mid = left + (right-left)/2;
      if (nums[left] > nums[right]) {
        left = mid;
      } else {
        right = mid;
      }
      if (nums[mid] == target) {
        return mid;
      }
    }
    return -1;
  }

  public static void rotateCount() {
    int[] nums = {9, 2, 3, 5, 7};
    int n = nums.length;
    int count = 0;
    while (nums[n-1] < nums[0]) {
        nums = rotateAntiClock(nums);
        count++;
    }
    System.out.println(count);
  }

  // rotate anti-clockwise
  public static int[] rotateAntiClock(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n];
    int t = nums[n-1];
    int i=n-1;
    for (; i>0; i--) {
      arr[i] = nums[i-1];
    }
    arr[i] = t;
    return arr;
  }

  // find first and last index of a given target number
  public static void findPair(int[] nums, int target) {
    int first=-1;
    int last=-1;
    int n=nums.length;
    for (int i=0;i<n; i++) {
      if (nums[i] == target && first==-1) {
        first = i;
      }
      if (nums[n-1-i] == target && last==-1) {
        last = n-1-i;
      }
    }
    System.out.println(first + ", " + last);
  }

  // reverse array in-place
  public static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++; end--;
    }
  }

  // rotate clock-wise
  // input [1 2 3 4 5 6 7 8], k=3
  // part 00: split at k position
  // part 01: reverse [1 2 3 4 5] => [5 4 3 2 1 6 7 8]
  // part 02: reverse [6 7 8] => [5 4 3 2 1 8 7 6 ]
  // part 03: reverse all => [ 6 7 8 1 2 3 4 5]
  public static void rotate(int[] nums, int k) {
    k = k % nums.length;
    if (k < 0) {
      k = k + nums.length;
    }
    reverse(nums, 0, nums.length-k-1);
    reverse(nums, nums.length-k, nums.length-1);
    reverse(nums, 0, nums.length-1);

    System.out.println(Arrays.toString(nums));
  }

  // rotate clock-wise k positions
  public static void rotate() {
    int nums[] = {1, 2, 3, 4, 5};
    int k=3;
    int i, t;
    while (k>0) {
      t = nums[nums.length-1];
      for (i=nums.length-1; i>0; i--) {
        nums[i] = nums[i-1];
      }
      nums[i] = t;
      k--;
    }
    System.out.println(Arrays.toString(nums));
  }

  // merge two sorted arrays without needing extra space
  // arr1 is m+n length
  public static int[] mergeSortedArraysInPlace(int[] arr1, int[] arr2) {
    int index1 = arr1.length-arr2.length-1; // points to last valid elements
    int index2 = arr2.length-1;

    int last = arr1.length-1;
    while (index1 >= 0 && index2 >= 0) {
      if (arr2[index2] > arr1[index1]) {
        arr1[last] = arr2[index2];
        index2--;
      } else {
        arr1[last] = arr1[index1];
        index1--;
      }
      last--;
    }
    // fill arr1 with leftover arr2 elements
    while (index2 > 0) {
      arr1[last] = arr2[index2];
      index2--; last--;
    }
    return arr1;
  }

  public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
    int i=0, j=0, k=0;
    int[] result = new int[arr1.length + arr2.length];
    while (i<arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        result[k++] = arr1[i++];
      } else {
        result[k++] = arr2[j++];
      }
    }
    // left over
    while (i<arr1.length) {
      result[k++] = arr1[i++];
    }
    while (j<arr2.length) {
      result[k++] = arr2[j++];
    }
    return result;
  }

  // divide and conquer approach
  public static int[] mergeKSortedArrays(int[][] arr, int start, int end) {
    if (start == end) {
      return arr[start];
    }
    int mid = start + (end-start)/2;
    int[] left = mergeKSortedArrays(arr, start, mid);
    int[] right = mergeKSortedArrays(arr, mid+1, end);
    return mergeSortedArrays(left, right);
  }

  // using min heap priority queue
  public static int[] mergeKSortedArrays(int[][] arr) {
    // since nested array is of different length, iterate and calculate total size
    int capacity = 0;
    for (int i=0; i<arr.length; i++) {
      capacity += arr[i].length;
    }
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(capacity);
    for (int i=0; i<arr.length; i++) {
      for (int j=0; j<arr[i].length; j++) {
        priorityQueue.add(arr[i][j]);
      }
    }

    int k=0;
    int[] result = new int[capacity];
    while (!priorityQueue.isEmpty()) {
      result[k++] = priorityQueue.remove();
    }
    return result;
  }

  // Leetcode 41: first missing positive
  /*
  Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
  You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
  Example 1:
  Input: nums = [1,2,0]
  Output: 3
  Explanation: The numbers in the range [1,2] are all in the array.

  Example 2:
  Input: nums = [3,4,-1,1]
  Output: 2
  Explanation: 1 is in the array but 2 is missing.
   */
  public static int firstMissingPositive(int[] nums) {
    Arrays.sort(nums);
    int missing = 1; // assume 1 is missing initially
    for (int num: nums) {
      if (num > 0) {
        if (num == missing) {
          missing ++;
        } else if (num > missing) {
          break;
        }
      }
    }
    return missing;
  }

  // Leetcode: 303 Range sum Query - Immutable
  /*
  Calculate the sum of the elements of nums between indices left and right inclusive where left <= right
  Input
  ["NumArray", "sumRange", "sumRange", "sumRange"]
  [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
  Output
  [null, 1, -1, -3]
   */
  public static int rangeSum(int[] nums, int left, int right) {
    // precalculate range sum first
    int[] presum = new int[nums.length];
    for (int i=0; i<nums.length; i++) {
      if (i==0) {
        presum[i] = nums[i];
      } else {
        presum[i] = presum[i-1] + nums[i];
      }
    }

    // return range only
    return left == 0 ? presum[right] - 0 : presum[right] - presum[left-1];
  }
}
