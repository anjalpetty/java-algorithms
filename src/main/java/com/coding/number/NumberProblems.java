package com.coding.number;

import java.util.HashMap;
import java.util.Map;

public class NumberProblems {

  public static void main(String[] args) {

    // nth fibonacci using memoization
    System.out.println(nthFibo(3));

    // generate first n fibonacci sequence
    System.out.println(">> first 10 fibonacci sequence");
    genFibonacci(10);

    // generate prime numbers for a given range
    System.out.println("\n>> prime numbers between 1 and 25");
    genPrime(1, 25);

    // rotate a number
    System.out.println("\n>> rotation of 12345 with 3 positions: " + rotateNum(12345, 3));

    // reverse a number
    System.out.println(">> reverse of 54321: " + reverseNum(54321));

    // count digits of a number
    System.out.println(">> number of digits of 54321: " + countDigits(54321));
  }

  // rotate a number of k times
  public static int rotateNum(int n, int k) {
    if (k<1) {
      return n;
    }
    int ksum=1;
    int i=1;
    while (i<=k) {
      ksum *=10;
      i++;
    }

    // step01: split the numbers by k position
    // step02: reverse separately
    // step03: combine back
    // step04: reverse all
    int p1 = n % ksum;
    int p2 = n / ksum;
    p1 = reverseNum(p1);
    p2 = reverseNum(p2);

    int combined = (p2 * ksum) + p1;
    int rotated = reverseNum(combined);
    return rotated;
  }

  // reverse a number
  // Leetcode: 7
  public static int reverseNum(int x) {
    boolean isNegative = false;
    if (x < 0) {
      isNegative = true;
      x = Math.abs(x);
    }
    long sum = 0;
    while (x > 0) {
      sum = (sum * 10) + (x % 10);
      x /=10;
    }
    if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
      return 0;
    }
    return isNegative ? -1 * (int)sum : (int)sum;
  }
  // count number of digits in a given number
  public static int countDigits(int n) {
    if (n<10 && n>-10) {
      return 1;
    }
    int count=0;
    while (n>0) {
      count++;
      n=n/10;
    }
    return count;
  }

  // fibonacci series with memoization
  static Map<Integer, Integer> map = new HashMap<>();
  public static int nthFibo(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    if (map.containsKey(n)) {
      return map.get(n);
    }
    int result = nthFibo(n-1) + nthFibo(n-2);
    map.put(n, result);

    return result;
  }

  public static void genFibonacci(int n) {
    if (n > 2) {
      int i=0;
      int j=1;
      System.out.print("0 ");
      for (int k=2; k<n; k++) {
        int f = i+j;
        System.out.print(f + " ");
        j=i;
        i=f;
      }
    } else if (n==2) {
      System.out.println("0 ");
    } else if (n==1) {
      System.out.println("0");
    } else {
      System.out.println("invalid number");
      return;
    }

  }

  // generate prime numbers for given ranges
  public static void genPrime(int start, int end) {
    if (start < 1 || end < 1) {
      System.out.println("invalid range");
      return;
    }

    while (start < end) {
      if (start < 4) {
        System.out.print(start + " ");
      } else {
        boolean flag = true;
        for (int div=2; div * div <= start; div++) {
          if (start % div == 0) {
            flag = false;
            break;
          }
        }
        if (flag) {
          System.out.print(start + " ");
        }
      }
      start++;
    }
  }
}
