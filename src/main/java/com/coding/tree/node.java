package com.coding.tree;

public class node {
  public int data;
  public node left;
  public node right;

  public node(int d) {
    data = d;
    left = null;
    right = null;
  }

  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }
}