package com.coding.tree;

public class PrintTree {

  public static void print(String prefix, tnode n, boolean isLeft) {
    if (n != null) {
      System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
      print(prefix + (isLeft ? "|   " : "    "), n.left, true);
      print(prefix + (isLeft ? "|   " : "    "), n.right, false);
    }
  }
}
