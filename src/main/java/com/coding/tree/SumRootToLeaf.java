package com.coding.tree;

// You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a
// binary number starting with the most significant bit.
/*
            1
          /   \
        0      1
       /  \   / \
      0    1 0   1

      100 + 101 + 110 + 111 => 4 + 5 + 6 + 7 => 22
*/

public class SumRootToLeaf {

  public static void main(String[] args) {
    tnode root = new tnode(1);
    root.left = new tnode(0);
    root.left.left = new tnode(0);
    root.left.right = new tnode(1);

    root.right = new tnode(1);
    root.right.left = new tnode(0);
    root.right.right = new tnode(1);


    System.out.println(sumRootToLeaf(root));
  }

  public static int sumRootToLeaf(tnode root) {
    return sumRootToLeaf(root, 0);
  }

  public static int sumRootToLeaf(tnode root, int sum) {
    if (root == null) {
      return 0;
    }
    sum = (sum << 1) + root.data;
    // if leaf
    if (root.left == null && root.right == null) {
      return sum;
    }
    return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
  }
}
