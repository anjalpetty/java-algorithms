package com.coding.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

  public static int maxLevel = 0;

  public static List<Integer> leftSideView(node root, int level, List<Integer> output) {
    if (root == null) {
      return output;
    }

    if (maxLevel < level) {
      output.add(root.data);
      maxLevel = level;
    }

    leftSideView(root.left, level + 1, output);
//    rightSideView(root.left, level + 1, output);

    return output;
  }

  public static List<Integer> rightSideView(node root, int level, List<Integer> output) {
    if (root == null) {
      return output;
    }

    if (maxLevel < level) {
      output.add(root.data);
      maxLevel = level;
    }

    rightSideView(root.right, level + 1, output);
//    rightSideView(root.left, level + 1, output);

    return output;
  }

  public static void main(String[] args) {
    /*
                         1
                     /      \
                    2         3
                 /    \      / \
               4       5    6   7
             /  \       \      /
           8     9      10    11
               /  \          /
             12   13        14
     */
    // print boundary
    // expected output - 1, 2, 4, 8, 12, 13, 10, 6, 14, 11, 7, 3
    node root = new node(1);

    root.left = new node(2);
    root.right = new node(3);

    root.left.left = new node(4);
    root.left.right = new node(5);

    root.left.left.left = new node(8);
    root.left.left.right = new node(9);

    root.left.left.right.left = new node(12);
    root.left.left.right.right = new node(13);

    root.left.right.right = new node(10);

    root.right.left = new node(6);
    root.right.right = new node(7);

    root.right.right.left = new node(11);
    root.right.right.left.left = new node(14);

    PrintTree.print("", root, false);

    List<Integer> output = new ArrayList<>();
//    leftSideView(root, 0, output);
    rightSideView(root, 0, output);

    for (int i : output) {
      System.out.print(i + " ");
    }
  }
}
