package com.coding.dynamic;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money. Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Input coins = [1, 2, 5], amount = 11
 * Output: 3 (5+5+1)
 *
 * Input coins = [2], amount = 3
 * Output: -1
 *
 * Input coins = [1,3,5,6,7], amount = 11
 * Output: 2 (5+6) not 7+3+1
 */
public class CoinChange {

  public static void main(String[] args) {
    System.out.println("Coins change: " + coinChange(new int[]{1, 2, 5}, 11));
    System.out.println("Coins change: " + coinChange(new int[]{1, 3, 5, 6, 7}, 11));
  }

  public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    Arrays.fill(dp, amount+1);
    dp[0] = 0;
    for (int i=0; i<=amount; i++) {
      for (int j=0; j<coins.length; j++) {
        if (coins[j] <=i) {
          dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
