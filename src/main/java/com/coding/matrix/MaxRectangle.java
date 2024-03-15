package com.coding.matrix;

import java.util.Stack;

/*

Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0
    ]

Output : 4
 */
public class MaxRectangle {

  public static void main(String[] args) {
    maxRectangle();
  }

  public static void maxRectangle() {
    int[][] mat =
        {
/*            {1, 1, 1},
            {0, 1, 1},
            {1, 0, 1}*/
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };

    int maxArea=0;
    int row=0;
    int col=0;
    for (row=0; row<mat.length; row++) {
      int currArea = 0; // current max

      for (col=0; col<mat[0].length; col++) {
//        currArea += aggr(mat, row, col);
        int area = aggr(mat, row, col);
//        System.out.print(area + " ");
      }
//      System.out.println(" ");
      /*if (currArea > maxArea) {
        maxArea = currArea;
      }*/
    }
//    System.out.println("maxRectangle Area: " + maxArea);
  }

  public static int aggr(int[][] mat, int row, int col) {
    if (row<= 0) {
      return mat[row][col];
    }

    if (mat[row][col] == 1) {
      return mat[row][col] + aggr(mat, row - 1, col);
    } else {
      return 0;
    }
  }

  public static int getMaxArea(int hist[], int n) {
    // Create an empty stack. The stack holds indexes of hist[] array
    // The bars stored in stack are always in increasing order of their
    // heights.
    Stack<Integer> s = new Stack<>();

    int max_area = 0; // Initialize max area
    int tp;  // To store top of stack
    int area_with_top; // To store area with top bar as the smallest bar

    // Run through all bars of given histogram
    int i = 0;
    while (i < n) {
      // If this bar is higher than the bar on top stack, push it to stack
      if (s.empty() || hist[s.peek()] <= hist[i]) {
        s.push(i++);

      // If this bar is lower than top of stack, then calculate area of rectangle
      // with stack top as the smallest (or minimum height) bar. 'i' is
      // 'right index' for the top and element before top in stack is 'left index'
      } else {
        tp = s.peek();  // store the top index
        s.pop();  // pop the top

        // Calculate the area with hist[tp] stack as smallest bar
        area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

        // update max area, if needed
        if (max_area < area_with_top) {
          max_area = area_with_top;
        }
      }
    }

    // Now pop the remaining bars from stack and calculate area with every
    // popped bar as the smallest bar
    while (s.empty() == false) {
      tp = s.peek();
      s.pop();
      area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

      if (max_area < area_with_top)
        max_area = area_with_top;
    }

    return max_area;

  }

}
