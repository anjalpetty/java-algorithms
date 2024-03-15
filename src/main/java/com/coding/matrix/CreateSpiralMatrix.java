package com.coding.matrix;

import java.util.Arrays;

// create a spiral matrix from a single dimension array
/**
 Input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

 Output:
 [  1   2   3   4  5 ]
 [ 16  17  18  19  6 ]
 [ 15  24  25  20  7 ]
 [ 14  23  22  21  8 ]
 [ 13  12  11  10  9 ]
 */
public class CreateSpiralMatrix {

  public static void main(String[] args) {
    int[] arr = {
        1, 2, 3, 4, 5,
        6, 7, 8, 9, 10,
        11, 12, 13, 14, 15,
        16, 17, 18, 19, 20,
        21, 22, 23, 24, 25
    };

    int[][] mat = createSpiral(arr);
    print(mat);
  }

  public static int[][] createSpiral(int[] arr) {

    int length = arr.length/5;
    int[][] mat = new int[length][length];

    int index=0;
    int top = 0, bottom = length-1;
    int left = 0, right = length-1;
    while(index<arr.length) {
      // row right
      for (int i=left; i <=right ; i++) {
        mat[top][i] = arr[index++];
      }
      // column down
      top++;
      for (int i=top; i<=bottom; i++) {
        mat[i][right] = arr[index++];
      }

      right--;
      // row left
      for (int i=right; i>=left; i--) {
        mat[bottom][i] = arr[index++];
      }
      // column up
      bottom--;
      for (int i=bottom; i>=top; i--) {
        mat[i][left]=arr[index++];
      }
      left++;
    }
    return mat;
  }

  public static void print(int[][] arr) {
    for (var r: arr) {
      System.out.println(Arrays.toString(r));
    }
  }

}
