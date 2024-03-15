package com.coding.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 Input:
 [  1   2   3   4  5 ]
 [ 16  17  18  19  6 ]
 [ 15  24  25  20  7 ]
 [ 14  23  22  21  8 ]
 [ 13  12  11  10  9 ]

 output: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
 */

public class SpiralMatrix {

  public static void main(String[] args) {
    int[][] matrix =
        {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
        };

    List<Integer> spiral = spiralOrder(matrix);
    System.out.println(spiral);
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    int col = 0;
    int rowLength = matrix.length;
    int colLength = matrix[0].length;
    List<Integer> list = new ArrayList<>();
    for (int row=0; row <rowLength; row++) {
      // row right
      for (col=row; col<colLength-row; col++) {
        list.add(matrix[row][col]);
      }
      // column down
      for (col=row+1; col<colLength-row; col++) {
        list.add(matrix[col][colLength-1-row]);
      }
      // row left
      for (col=row+1; col<colLength-row; col++) {
        list.add(matrix[colLength-1-row][colLength-1-col]);
      }
      // column up
      for (col=row+1; col<colLength-row-1; col++) {
        list.add(matrix[rowLength-1-col][row]);
      }
    }
    return list;
  }

}
