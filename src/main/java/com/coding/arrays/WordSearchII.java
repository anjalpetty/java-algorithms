package com.coding.arrays;


import java.util.ArrayList;
import java.util.List;

// 212. Word Search II
/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
|----------------
| o | a | a | n |
|----------------
| e | t | a | e |
-----------------
| i | h | k | r |
-----------------
| i | f | l | v |
-----------------

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
 */
public class WordSearchII {

  public static void main(String[] args) {
    char[][] board = {
      {'o','a','a','n'},
      {'e','t','a','e'},
      {'i','h','k','r'},
      {'i','f','l','v'}
    };
    String[] words = {"oath","pea","eat","rain"};
    WordSearchII wordSearchII = new WordSearchII();
    List<String> result = wordSearchII.findWords(board, words);
    result.stream().forEach(word -> System.out.println(word));
  }

  class trieNode {
    trieNode[] children;
    String word;

    public trieNode() {
      children = new trieNode[26];
      word = null;
    }
  }

  public List<String> findWords(char[][] board, String[] words) {

    List<String> result = new ArrayList<>();
    if (board == null || board.length == 0) {
      return result;
    }

    trieNode root = new trieNode();
    buildTrie(root, words);
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[i].length; j++) {
        char c = board[i][j];
        if (root.children[c - 'a'] != null) {
          dfs(board, i, j, root, result);
        }
      }
    }
    return result;
  }

  private void dfs(char[][] board, int i, int j, trieNode curr, List<String> result) {
    if (i < 0 || i>= board.length || j < 0 || j >= board[i].length) {
      return;
    }

    if (board[i][j] == '#') { // if same indices
      return;
    }
    char c = board[i][j];

    if (curr.children[c - 'a'] == null) {
      return;
    }
    curr = curr.children[c - 'a'];
    if (curr.word != null) {
      result.add(curr.word);
      curr.word = null;
    }

    board[i][j] = '#';
    dfs(board,i+1, j, curr, result);
    dfs(board,i-1, j, curr, result);
    dfs(board,i, j+1, curr, result);
    dfs(board,i, j-1, curr, result);

    board[i][j] = c;
  }

  private void buildTrie(trieNode root, String[] words) {
    for (String s : words) {
      trieNode cur = root;

      for (char c : s.toCharArray()) {
        int index = (c - 'a');
        if (cur.children[index] == null) {
          cur.children[index] = new trieNode();
        }
        cur = cur.children[index];
      }

      cur.word = s;
    }
  }
}
