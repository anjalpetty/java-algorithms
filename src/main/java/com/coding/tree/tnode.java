package com.coding.tree;

public class tnode {
  public int data;
  public tnode left;
  public tnode right;

  public tnode(int d) {
    data = d;
    left = null;
    right = null;
  }

  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }
}