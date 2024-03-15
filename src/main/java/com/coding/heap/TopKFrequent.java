package com.coding.heap;

import java.util.*;

/*
 leetcode: 347. Top K Frequent Elements
 Given an integer array nums and an integer k, return the k most frequent elements.
 You may return the answer in any order.

 Example 1:
 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]

 Example 2:
 Input: nums = [1], k = 1
 Output: [1]
 */
public class TopKFrequent {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
  }

  public static int[] topKFrequent(int[] nums, int k) {

    if (k == nums.length) {
      return nums;
    }
    int[] result = new int[k];

    Map<Integer, Integer> map = new HashMap<>();
    for (int n: nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    for (int n: map.keySet()) {
      priorityQueue.add(n);
    }

    for (int i=0; i<k; i++) {
      result[i] = priorityQueue.poll();
    }

    return result;
  }
}
