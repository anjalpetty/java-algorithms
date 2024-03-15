package com.coding.tree;

class SNode {
  String val;
  SNode left;
  SNode right;

  public SNode(String val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

public class EvalExpression {

  static double compute(String operator, double x, double y) {
    if (operator.equals("+")) { return x + y; }
    if (operator.equals("-")) { return x - y; }
    if (operator.equals("*")) { return x * y; }
    if (operator.equals("/")) { return x / y; }
    return 0;
  }

  static boolean isLeaf(SNode node) {
    return node.left == null && node.right == null;
  }

  public static double eval(SNode root) {
    if (root == null) {
      return 0;
    }

    if (isLeaf(root)) {
      return Integer.parseInt(root.val);
    }

    double leftVal = eval(root.left);
    double rightVal = eval(root.right);

    return compute(root.val, leftVal, rightVal);
  }

  public static void main(String[] args) {

    /*
                  +
               /    \
             *       /
            / \    /  \
           -   5  21  7
          / \
        10   5
     */
    // ((10 - 5) * 5) + (21 / 7) => (5 * 5) + 3 => 28
    SNode root = new SNode("+");
    root.left = new SNode("*");
    root.right = new SNode("/");
    root.left.left = new SNode("-");
    root.left.right = new SNode("5");
    root.right.left = new SNode("21");
    root.right.right = new SNode("7");
    root.left.left.left = new SNode("10");
    root.left.left.right = new SNode("5");

    System.out.println("Eval result: " + eval(root));

  }
}
