package com.coding.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a set of distinct numbers, find all of its permutations.
Example 1:

Input: [1,3,5]
Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */
public class Permutations {
  public static void main(String[] args) {
    List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
    System.out.print("Here are all the permutations: " + result);
  }


  // brute-force way
  public static List<List<Integer>> findPermutations(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i=0; i<nums.length; i++) {
      for (int j=0; j<nums.length-1; j++) {
        int temp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = temp;
        result.add(digits(nums));
      }
    }
    return result;
  }

  public static List<Integer> digits(int[] nums) {
    List<Integer> sub = new ArrayList<>();
    for (int n: nums) {
      sub.add(n);
    }
    return sub;
  }

  // breadth-first-search way
  public static List<List<Integer>> findPermutationsBFS(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<List<Integer>> permutations = new LinkedList<>();
    permutations.add(new ArrayList<>());
    for (int currentNumber : nums) {
      // we will take all existing permutations and add the current number to create new permutations
      int n = permutations.size();
      for (int i = 0; i < n; i++) {
        List<Integer> oldPermutation = permutations.poll();
        // create a new permutation by adding the current number at every position
        for (int j = 0; j <= oldPermutation.size(); j++) {
          List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
          newPermutation.add(j, currentNumber);
          if (newPermutation.size() == nums.length)
            result.add(newPermutation);
          else
            permutations.add(newPermutation);
        }
      }
    }
    return result;
  }

}
