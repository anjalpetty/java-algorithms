package com.coding.tree;

import java.util.*;

/*
            5
          /  \
        9    3
       /  \    \
      4    2    1
     /      \
    7        6
*/
public class TreeProblems {

  public static int maxLevel = 0;
  private static int[] inOrder = new int[8];
  private static int[] preOrder = new int[8];
  private static int[] postOrder = new int[8];
  private static int i=0, j=0, k=0;

  public static void main(String[] args) {

    node root = new node(5);
    root.left = new node(9);
    root.right = new node(3);

    root.left.left = new node(4);
    root.left.right = new node(2);

    root.right.right = new node(1);

    root.left.left.left = new node(7);
    root.left.right.right = new node(6);

    System.out.println("inOrder");
    inOrder(root);
    System.out.println("\n" + "inOrder Iterative");
    inOrderIterative(root);
    System.out.println("\n" + "preOrder");
    preOrder(root);
    System.out.println("\n" + "preOrder Iterative");
    preOrderIterative(root);
    System.out.println("\n" + "postOrder");
    postOrder(root);
    System.out.println("\n" + "postOrder Iterative");
    postOrderIterative(root);

    System.out.println("\n" + "All traversal>> ");
    traversal(root);
    System.out.println("inOrder  : " + Arrays.toString(inOrder));
    System.out.println("preOrder : " + Arrays.toString(preOrder));
    System.out.println("postOrder: " + Arrays.toString(postOrder));

    List<Integer> output = new ArrayList<>();
    System.out.println("left side view (recursive)");
    output = leftSideView(root, 1, output);
    for (Integer out : output) {
      System.out.print(out + " ");
    }
    System.out.println("");
    System.out.println("left side view with Queue");
    output.clear();
    output = leftSideView(root);
    for (Integer out : output) {
      System.out.print(out + " ");
    }

    output.clear();
    maxLevel = 0;
    System.out.println("");
    System.out.println("right side view (recursive)");
    output = rightSideView(root, 1, output);
    for (Integer out : output) {
      System.out.print(out + " ");
    }

    System.out.println("");
    System.out.println("right side view with Queue)");
    output.clear();
    output = rightSideView(root);
    for (Integer out : output) {
      System.out.print(out + " ");
    }

    System.out.println("\n" + "maxDepth (recur): " + maxDepthRecur(root));
    System.out.println("maxDepth (BFS): " + maxDepth(root));
    System.out.println("minDepth (BFS): " + minDepth(root));

    System.out.println("levelOrderTraversal");
    levelOrderTraversal(root);
    System.out.println("\n" + "print by level");
    printByLevel(root);

    System.out.println("");
    System.out.println("treeHeight: " + treeHeight(root));
    System.out.println("treeMax   : " + treeMax(root));
    System.out.println("treeMin   : " + treeMin(root));
    System.out.println("treeSum   : " + treeSum(root));
    System.out.println("treeSumIterative: " + treeSumIterative(root));
    System.out.println("sumOfPathNumbers: " + sumOfPathNumbers(root)); // 5947 + 5926 + 531 => 12404
    System.out.println("rootToLeafMax   : " + rootToLeafMax(root));
    System.out.println("rootToLeafMaxIterative: " + rootToLeafMaxIter(root));
    System.out.println("11 existsInTree : " + existsInTree(root, 11));
    System.out.println("hasPath         : " + hasPath(root, 24)); // (5 + 11 + 2 + 6)
//    System.out.println("kthLargetNode: " + kthLargestNode(root, 3).data);

    node root1 = new node(1);
    root1.left = new node(2);
    node root2 = new node(1);
    root2.left = null;
    root2.right = new node(2);

    System.out.println("\n" + "isSame: " + isSameTree(root1, root2));

    System.out.println("before mirror");
    printTree(root);
    mirrorTree(root);
    System.out.println("");
    System.out.println("after mirror");
    printTree(root);
  }

  public static node insertNode(node current, int d) {
    if (current == null) {
      return new node(d);
    } else if (d > current.data) {
      current.right = insertNode(current.right, d);
    } else if (d < current.data) {
      current.left = insertNode(current.left, d);
    }
    return current;
  }

  public static void inOrder(node current) {
    if (current != null) {
      inOrder(current.left);
      System.out.print(current.data + " ");
      inOrder(current.right);
    }
  }

  public static void preOrder(node current) {
    if (current != null) {
      System.out.print(current.data + " ");
      preOrder(current.left);
      preOrder(current.right);
    }
  }

  public static void postOrder(node current) {
    if (current != null) {
      postOrder(current.left);
      postOrder(current.right);
      System.out.print(current.data + " ");
    }
  }

  public static void traversal(node current) {
    if (current != null) {
      preOrder[i++] = current.data;
      traversal(current.left);
      inOrder[j++] = current.data;
      traversal(current.right);
      postOrder[k++] = current.data;
    }
  }

  public static void inOrderIterative(node root) {
    if (root == null)
      return;

    Stack<node> s = new Stack<>();
    node curr = root;

    // traverse the tree
    while (curr != null || s.size() > 0) {

      while (curr != null) {
        s.push(curr);
        curr = curr.left;
      }

      /* Current must be NULL at this point */
      curr = s.pop();

      System.out.print(curr.data + " ");
      curr = curr.right;
    }
  }

  public static void preOrderIterative(node root) {
    if (root == null)
      return;

    Stack<node> s = new Stack<>();
    node curr = root;

    s.push(curr);
    // traverse the tree
    while (s.size() > 0) {
      curr = s.pop();
      System.out.print(curr.data + " ");
      if (curr.right != null) {
        s.push(curr.right);
      }
      if (curr.left != null) {
        s.push(curr.left);
      }
    }
  }

  public static void postOrderIterative(node root) {
    if (root == null)
      return;

    Stack<node> s = new Stack<>();
    node curr = root;
    node pre = null;
    // traverse the tree
    while (curr != null || !s.isEmpty()) {
      if (curr != null) {
        s.push(curr);
        curr = curr.left;
      } else {
        curr = s.peek();
        if (curr.right == null || curr.right == pre) {
          System.out.print(curr.data + " ");
          curr = s.pop();
          pre = curr;
          curr = null;
        } else {
          curr = curr.right;
        }
      }
    }
  }

  public static List<Integer> leftSideView(node root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Queue<node> queue = new LinkedList<>();
    queue.add(root);
    list.add(root.data);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i=0; i<size; i++) {
        node curr = queue.poll();
        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
      if (!queue.isEmpty()) {
        list.add(queue.peek().data);
      }
    }
    return list;
  }

  public static List<Integer> leftSideView(node root, int level, List<Integer> output) {
    if (root == null) {
      return output;
    }

    if (maxLevel < level) {
      output.add(root.data);
      maxLevel = level;
    }

    leftSideView(root.left, level + 1, output);
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
    return output;
  }

  public static List<Integer> rightSideView(node root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Queue<node> queue = new LinkedList<>();
    queue.add(root);
    list.add(root.data);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i=0; i<size; i++) {
        node curr = queue.poll();

        if (curr.right != null) {
          queue.add(curr.right);
        }
        if (curr.left != null) {
          queue.add(curr.left);
        }
      }
      if (!queue.isEmpty()) {
        list.add(queue.peek().data);
      }
    }
    return list;
  }

  public static void leftRightEdgesOnly(node root) {

    if (root == null) {
      return;
    }


  }

  public static void printByLevel(node root) {

    Queue<node> queue = new LinkedList<>();
    if (root == null) {
      return;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      node curr = queue.poll();
      System.out.print(curr.data + " ");
      if (curr.left != null) {
        queue.add(curr.left);
      }
      if (curr.right != null) {
        queue.add(curr.right);
      }
    }
  }

  public static boolean printLevel(node root, int level) {
    // base case
    if (root == null) {
      return false;
    }

    if (level == 1) {
      System.out.print(root.data + " ");

      // return true if at least one node is present at a given level
      return true;
    }

    boolean left = printLevel(root.left, level - 1);
    boolean right = printLevel(root.right, level - 1);

    return left || right;
  }

  // leetcode 104. maximum depth of binary tree
  public static int maxDepthRecur(node root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right));
  }

  public static int maxDepth(node root) {
    if (root == null) {
      return 0;
    }

    Queue<node> queue = new LinkedList<>();
    queue.add(root);
    int depth=0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i=0; i<size; i++) {
        node curr = queue.poll();
        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
      depth++;
    }
    return depth;
  }

  // Minimum Depth of a Binary Tree (easy)
  // The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
  public static int minDepth(node root) {
    if (root == null || (root.left == null && root.right == null)) {
      return 1;
    }
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }

  // Function to print level order traversal of a given binary tree
  public static void levelOrderTraversal(node root) {
    // start from level 1 — till the height of the tree
    int level = 1;

    // run till printLevel() returns false
    while (printLevel(root, level)) {
      level++;
    }
  }

  public static int treeSum(node root) {
    if (root == null) {
      return 0;
    }

    return root.data + treeSum(root.left) + treeSum(root.right);
  }

  public static int treeSumIterative(node root) {
    Queue<node> queue = new LinkedList<>();

    if (root == null) {
      return 0;
    }

    int sum = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      node node = queue.poll();
      sum += node.data;
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
    return sum;
  }

  public static int sumOfPathNumbers(node root) {
    if (root == null) {
      return 0;
    }
    return findPathSum(root, 0);
  }

  public static int findPathSum(node root, int pathSum) {
    if (root == null) {
      return 0;
    }

    pathSum = (10 * pathSum) + root.data;
    if (root.left == null & root.right == null) {
      return pathSum;
    }
    return findPathSum(root.left, pathSum) + findPathSum(root.right, pathSum);
  }

  public static int treeMin(node root) {
    if (root == null) {
      return -1;
    }

    Queue<node> queue = new LinkedList<>();
    queue.add(root);

    int min = root.data;
    while (!queue.isEmpty()) {
      node node = queue.poll();
      if (node.data < min) {
        min = node.data;
      }
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }

    return min;
  }

  public static int rootToLeafMax(node root) {
    if (root == null) {
      return -1;
    }

    if (root.left == null && root.right == null) {
      return root.data;
    }
    int maxSum = Math.max(rootToLeafMax(root.left), rootToLeafMax(root.right));
    return root.data + maxSum;
  }

  // root to left (path with maximum value)
  public static int rootToLeafMaxIter(node root) {

    if (root == null) {
      return -1;
    }
    Queue<node> queue = new LinkedList<>();
    queue.add(root);

    int sum = 0;
    while (!queue.isEmpty()) {
      node node = queue.poll();
      sum += node.data;
      if (node.left != null && node.right != null) {
        if (node.left.data > node.right.data) {
          queue.add(node.left);
        }
      } else if (node.left != null) {
        queue.add(node.left);
      } else if (node.right != null) {
        queue.add(node.right);
      }
    }
    return sum;
  }

  public static boolean isSameTree(node p, node q) {
    if (p == null && q== null) {
      return true;
    } else if (p == null || q == null) {
      return false;
    }
    return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static int treeMax(node root) {
    if (root == null) {
      return -1;
    }
    int leftMax = treeMax(root.left);
    int rightMax = treeMax(root.right);

    return Math.max(Math.max(root.data, leftMax), rightMax);
  }

  public static int treeHeight(node root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
  }

  public static boolean existsInTree(node root, int target) {
    if (root == null) {
      return false;
    }
    boolean leftFound = existsInTree(root.left, target);
    boolean rightFound = existsInTree(root.right, target);

    return root.data == target || leftFound || rightFound;
  }

  public static void mirrorTree(node root) {
    if (root == null) {
      return;
    }
    node temp = root.left;
    root.left = root.right;
    root.right = temp;
    mirrorTree(root.left);
    mirrorTree(root.right);
  }

  // find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals sum
  public static boolean hasPath(node root, int sum) {
    if (root == null) {
      return false;
    }

    if (root.data == sum && root.left == null && root.right == null) {
      return true;
    }

    return hasPath(root.left, sum-root.data) || hasPath(root.right, sum-root.data);
  }

  public static void printTree(node root) {
    if (root == null) {
      return;
    }
    for (int level=1; level <= treeHeight(root); level++) {
      printCurrentLevel(root, level);
    }
  }

  public static void printCurrentLevel(node root, int level) {
    if (root == null) {
      return;
    }
    if (level ==1) {
      System.out.print(root.data + " ");
    } else if (level > 1) {
      printCurrentLevel(root.left, level-1);
      printCurrentLevel(root.right, level-1);
    }
  }

  public static List<node> inOrder(node root, List<node> list) {
    if (root != null) {
      inOrder(root.left);
      list.add(root);
      inOrder(root);
    }
    return list;
  }

  public static node kthLargestNode(node root, int k) {
    if (root == null) {
      return null;
    }
    List<node> list = new ArrayList<>();
    list = inOrder(root, list);

    if (k>list.size()) {
      return null;
    }
    return list.get(list.size()-k);
  }
}
