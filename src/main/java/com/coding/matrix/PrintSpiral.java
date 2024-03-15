package com.coding.matrix;

/**
 Input:
 [  1   2   3   4  5 ]
 [ 16  17  18  19  6 ]
 [ 15  24  25  20  7 ]
 [ 14  23  22  21  8 ]
 [ 13  12  11  10  9 ]

 output: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
 */

public class PrintSpiral {

  public static void main(String[] args) {
    int[][] mat =
        {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
        };

    printSpiral(mat);
  }

  public static void printSpiral(int[][] mat) {


    int col = 0;
    int rowLength = mat.length;
    int colLength = mat[0].length;
    for (int row=0; row <rowLength; row++) {
      // row right
      for (col=row; col<colLength-row; col++) {
        System.out.print(mat[row][col] + " ");
      }
      // column down
      for (col=row+1; col<colLength-row; col++) {
        System.out.print(mat[col][colLength-1-row] + " ");
      }
      // row left
      for (col=row+1; col<colLength-row; col++) {
        System.out.print(mat[colLength-1-row][colLength-1-col] + " ");
      }
      // column up
      for (col=row+1; col<colLength-row-1; col++) {
        System.out.print(mat[rowLength-1-col][row] + " ");
      }
    }

  }

}
