package com.coding.arrays;

/*

 Leetcode 79. Word Search
Input: board =
[
 ["A","B","C","E"],
 ["S","F","C","S"],
 ["A","D","E","E"]
]
word = "ABCCED", return true

word = "SEE, return true
word "ABCB", return false

Constraints:
1. You can move in 4 directions (left, right, top, bottom)
2. A node once traversed cannot re-traversed

*/

// Use DFS
class WordSearch {

  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };

    System.out.println("is the word \"ABCCED\" found: " + checkBoard(board, "ABCCED"));
    System.out.println("is the word \"SEE\" found: " + checkBoard(board, "SEE"));
    System.out.println("is the word \"ABCB\" found: " + checkBoard(board, "ABCB"));
  }

  public static boolean checkBoard(char[][] board, String word) {
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[i].length; j++) {
        if (board[i][j] == word.charAt(0) && dfsAround(board, word, 0, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean dfsAround(char[][] board, String word, int index, int row, int column) {
    if (index == word.length()) {
      return true;
    }
    if (row < 0 || row >= board.length || column < 0 || column >= board[row].length
        || board[row][column] != word.charAt(index)) {
      return false;
    }

    char temp = board[row][column]; // little trick so that we don't use the current cell
    board[row][column] = ' ';
    boolean found = dfsAround(board, word, index+1, row+1, column)
        || dfsAround(board, word, index+1, row-1, column)
        || dfsAround(board, word, index+1, row, column+1)
        || dfsAround(board, word, index+1, row, column-1);
    board[row][column] = temp;
    return found;
  }

}