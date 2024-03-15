package com.coding.dynamic;

/*
leetcode 70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */
public class ClimbingStairs {

  public static void main(String[] args) {
    System.out.println("# of ways to climb n steps: " + climbStairs(3));
    System.out.println("# of ways to climb n steps: " + climb(2));
  }

  public static int climbStairs(int n) {
     int one=1, two=1;
    for (int i=0; i<n-1; i++) {
      int temp = one;
      one = one + two;
      two = temp;
    }

    return one;
  }

  // f(n) = f(n-1) + f(n-2)
  public static int climb(int n) {

    int[] dp = new int[n+1];
    dp[0] = 1; dp[1] = 1;

    for (int i=2; i<=n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

}
