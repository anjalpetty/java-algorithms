package com.coding.subsets;

import java.util.ArrayList;
import java.util.List;

/*
Given a set with distinct elements, find all of its distinct subsets.
Example 1:
Input: [1, 3]
Output: [], [1], [3], [1,3]

Example 2:
Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class DistinctSubsets {

  public static void main(String[] args) {
    List<List<Integer>> result = findSubsets(new int[] { 1, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = findSubsets(new int[] { 1, 5, 3 });
    System.out.println("Here is the list of subsets: " + result);

  }

  // Breadth First Search (BFS) approach
  // space complexity O(2^n) outputs
  // time complexity O(N * 2^n)
  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();

    subsets.add(new ArrayList<>());
    for (int currNum : nums) {
      int n = subsets.size();
      for (int i=0; i<n; i++) {
        List<Integer> set = new ArrayList<>(subsets.get(i));
        set.add(currNum);
        subsets.add(set);
      }
    }

    return subsets;
  }

}
