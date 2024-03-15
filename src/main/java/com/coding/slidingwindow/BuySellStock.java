package com.coding.slidingwindow;

/**
 * Best time to buy and sell stock
 * You have given an array with ith element is the price of a given stock on day i
 * If you were only permitted to complete at most one transaction (i.e buy one and sell one share of the stack),
 * Design an algorithm to find the maximum profit
 *
 * NOTE: you cannot sell a stock before you buy one
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 *
 * Buy on day 2 (price=1) and sell on day 5 (price=6), profit 6-1=5. Not 7-1=6, as selling price needs to be larger
 * than buying price.
 */
public class BuySellStock {

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    System.out.println(maxProfit2(new int[]{7,6,4,3,1}));
  }

  // buy at low and sell at high
  // left pointer - buy
  // right pointer - sell
  public static int maxProfit(int[] arr) {
    int left=0;
    int right=1;
    int maxProfit = 0;

    while (right < arr.length) {
      if ( arr[left] < arr[right]) {
        int profit = arr[right]-arr[left];
        maxProfit = Math.max(maxProfit, profit);
      } else {
        left = right;
      }
      right++;
    }
    return maxProfit;
  }

  public static int maxProfit2(int[] prices) {
    int profit = -1;
    int buyValue = prices[0];

    for (int i=1; i<prices.length; i++) {
      if (prices[i] < buyValue) {
        buyValue = prices[i];
        profit = 0;
      }

      if ((prices[i]-buyValue) > profit) {
        profit = prices[i]-buyValue;
      }
    }
    return profit;
  }
}
