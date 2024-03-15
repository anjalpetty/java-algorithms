package com.coding.matrix;

// rotate matrix by 90 degrees clockwise
// tip
//   step-1: transpose
//   step-2: swap columns

import java.util.Arrays;

public class Rotate {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    rotate(matrix);
    print(matrix);
  }

  public static void transpose(int[][] matrix) {
    int rowLength = matrix.length;

    for (int r=0; r<rowLength; r++) {
      for (int c=0; c<r; c++) {
        int temp = matrix[r][c];
        matrix[r][c] = matrix[c][r];
        matrix[c][r] = temp;
      }
    }
  }

  public static void rotate(int[][] matrix) {

    // step-1: transpose
    transpose(matrix);

    int rowLength = matrix.length;
    int colLength = matrix[0].length;
    // step-2: column swap
    for (int r=0; r<rowLength; r++) {
      for (int c=0; c<colLength/2; c++) {
        int temp = matrix[r][c];
        matrix[r][c] = matrix[r][colLength-1-c];
        matrix[r][colLength-1-c] = temp;
      }
    }
  }

  public static void print(int[][] matrix) {
    for (var r: matrix) {
      System.out.println(Arrays.toString(r));
    }
  }

}
