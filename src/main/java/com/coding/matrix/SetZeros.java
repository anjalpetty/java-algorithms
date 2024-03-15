package com.coding.matrix;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 Input:
  [
    [1, 1, 1],
    [1, 0, 1],
    [1, 1, 1],
  ]

 Output:
 [
 [1, 0, 1],
 [0, 0, 0],
 [1, 0, 1],
 ]

 Input:
 [
 [0, 1, 2, 0],
 [3, 4, 5, 2],
 [1, 3, 1, 5],
 ]

 Output:
 [
 [0, 0, 0, 0],
 [0, 4, 5, 0],
 [0, 3, 1, 0],
 ]
 */
public class SetZeros {
  public static void main(String[] args) {
    int[][] matrix1 = {
        {0, 1, 2, 0},
        {3, 4, 5, 2},
        {1, 3, 1, 5},
    };
    setZeroes(matrix1);
    print(matrix1);

    int[][] matrix2 = {
        {1, 1, 1},
        {1, 0, 1},
        {1, 1, 1},
    };
    setZeroes(matrix2);
    print(matrix2);
  }

  public static void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    boolean firstRowZero = false;
    boolean firstColZero = false;

    for (int j=0; j<cols; j++) {
      if (matrix[0][j] == 0) {
        firstRowZero = true;
        break;
      }
    }
    for (int i=0; i<rows; i++) {
      if (matrix[i][0] == 0) {
        firstColZero = true;
        break;
      }
    }
    for (int i=1; i<rows; i++) {
      for (int j=1; j<cols; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for (int i=1; i<rows; i++) {
      for (int j=1; j<cols; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j]=0;
        }
      }
    }
    if (firstRowZero) {
      for (int j = 0; j < cols; j++) {
        matrix[0][j] = 0;
      }
    }
    if (firstColZero) {
      for (int i = 0; i < rows; i++) {
        matrix[i][0] = 0;
      }
    }
  }

  public static void print(int[][] arr) {
    for (var r: arr) {
      System.out.println(Arrays.toString(r));
    }
  }
}
