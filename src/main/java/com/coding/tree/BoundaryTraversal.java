package com.coding.tree;

import java.util.ArrayList;
import java.util.List;

// leetcode: 545 Boundary of a binary tree in anti-clockwise direction
/* steps
  01. print root node
  02. print left boundary in top-down manner, except root and leaf nodes
  03. print leaf nodes in inorder manner
  04. pring right boundary in bottom up manner, except root and leaf nodes
 */
public class BoundaryTraversal {

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

    printBoundary(root);
  }

  public static void printBoundary(node root) {
    if (root != null) {
      System.out.print(root.data + " ");
      printBoundaryLeft(root.left);

      printLeaves(root.left);
      printLeaves(root.right);

      printBoundaryRight(root.right);
    }
  }

  public static void printBoundaryLeft(node root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      System.out.print(root.data + " ");
      printBoundaryLeft(root.left);
    } else if (root.right != null) {
      System.out.print(root.data + " ");
      printBoundaryLeft(root.right);
    }
  }

  public static void printLeaves(node root) {
    if (root == null) {
      return;
    }
    printLeaves(root.left);
    if (root.left == null && root.right == null) {
      System.out.print(root.data + " ");
    }
    printLeaves(root.right);
  }

  public static void printBoundaryRight(node root) {
    if (root == null) {
      return;
    }
    if (root.right != null) {
      printBoundaryRight(root.right);
      System.out.print(root.data + " ");
    } else if (root.left != null) {
      printBoundaryRight(root.left);
      System.out.print(root.data + " ");
    }
  }
}
