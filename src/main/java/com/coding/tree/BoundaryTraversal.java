package com.coding.tree;

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
    tnode root = new tnode(1);

    root.left = new tnode(2);
    root.right = new tnode(3);

    root.left.left = new tnode(4);
    root.left.right = new tnode(5);

    root.left.left.left = new tnode(8);
    root.left.left.right = new tnode(9);

    root.left.left.right.left = new tnode(12);
    root.left.left.right.right = new tnode(13);

    root.left.right.right = new tnode(10);

    root.right.left = new tnode(6);
    root.right.right = new tnode(7);

    root.right.right.left = new tnode(11);
    root.right.right.left.left = new tnode(14);

    printBoundary(root);
  }

  public static void printBoundary(tnode root) {
    if (root != null) {
      System.out.print(root.data + " ");
      printBoundaryLeft(root.left);

      printLeaves(root.left);
      printLeaves(root.right);

      printBoundaryRight(root.right);
    }
  }

  public static void printBoundaryLeft(tnode root) {
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

  public static void printLeaves(tnode root) {
    if (root == null) {
      return;
    }
    printLeaves(root.left);
    if (root.left == null && root.right == null) {
      System.out.print(root.data + " ");
    }
    printLeaves(root.right);
  }

  public static void printBoundaryRight(tnode root) {
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
