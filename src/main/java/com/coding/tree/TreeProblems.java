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

    tnode root = new tnode(5);
    root.left = new tnode(9);
    root.right = new tnode(3);

    root.left.left = new tnode(4);
    root.left.right = new tnode(2);

    root.right.right = new tnode(1);

    root.left.left.left = new tnode(7);
    root.left.right.right = new tnode(6);

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
    System.out.println("hasPathSum      : " + hasPathSum(root, 24)); // (5 + 11 + 2 + 6)
    List<List<Integer>> result = pathSumII(root, 22);
    System.out.println("hasPathSumII    : " + result); // (5 + 11 + 2 + 6)
//    System.out.println("kthLargetNode: " + kthLargestNode(root, 3).data);

    tnode root1 = new tnode(1);
    root1.left = new tnode(2);
    tnode root2 = new tnode(1);
    root2.left = null;
    root2.right = new tnode(2);

    System.out.println("\n" + "isSame: " + isSameTree(root1, root2));

    System.out.println("before mirror");
    printTree(root);
    mirrorTree(root);
    System.out.println("");
    System.out.println("after mirror");
    printTree(root);
  }

  public static tnode insertNode(tnode current, int d) {
    if (current == null) {
      return new tnode(d);
    } else if (d > current.data) {
      current.right = insertNode(current.right, d);
    } else if (d < current.data) {
      current.left = insertNode(current.left, d);
    }
    return current;
  }

  public static void inOrder(tnode current) {
    if (current != null) {
      inOrder(current.left);
      System.out.print(current.data + " ");
      inOrder(current.right);
    }
  }

  public static void preOrder(tnode current) {
    if (current != null) {
      System.out.print(current.data + " ");
      preOrder(current.left);
      preOrder(current.right);
    }
  }

  public static void postOrder(tnode current) {
    if (current != null) {
      postOrder(current.left);
      postOrder(current.right);
      System.out.print(current.data + " ");
    }
  }

  public static void traversal(tnode current) {
    if (current != null) {
      preOrder[i++] = current.data;
      traversal(current.left);
      inOrder[j++] = current.data;
      traversal(current.right);
      postOrder[k++] = current.data;
    }
  }

  public static void inOrderIterative(tnode root) {
    if (root == null)
      return;

    Stack<tnode> s = new Stack<>();
    tnode curr = root;

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

  public static void preOrderIterative(tnode root) {
    if (root == null)
      return;

    Stack<tnode> s = new Stack<>();
    tnode curr = root;

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

  public static void postOrderIterative(tnode root) {
    if (root == null)
      return;

    Stack<tnode> s = new Stack<>();
    tnode curr = root;
    tnode pre = null;
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

  public static List<Integer> leftSideView(tnode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Queue<tnode> queue = new LinkedList<>();
    queue.add(root);
    list.add(root.data);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i=0; i<size; i++) {
        tnode curr = queue.poll();
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

  public static List<Integer> leftSideView(tnode root, int level, List<Integer> output) {
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

  public static List<Integer> rightSideView(tnode root, int level, List<Integer> output) {
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

  public static List<Integer> rightSideView(tnode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Queue<tnode> queue = new LinkedList<>();
    queue.add(root);
    list.add(root.data);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i=0; i<size; i++) {
        tnode curr = queue.poll();

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

  public static void leftRightEdgesOnly(tnode root) {

    if (root == null) {
      return;
    }


  }

  public static void printByLevel(tnode root) {

    Queue<tnode> queue = new LinkedList<>();
    if (root == null) {
      return;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      tnode curr = queue.poll();
      System.out.print(curr.data + " ");
      if (curr.left != null) {
        queue.add(curr.left);
      }
      if (curr.right != null) {
        queue.add(curr.right);
      }
    }
  }

  public static boolean printLevel(tnode root, int level) {
    // base case
    if (root == null) {
      return false;
    }

    if (level == 1) {
      System.out.print(root.data + " ");

      // return true if at least one tnode is present at a given level
      return true;
    }

    boolean left = printLevel(root.left, level - 1);
    boolean right = printLevel(root.right, level - 1);

    return left || right;
  }

  // leetcode 104. maximum depth of binary tree
  public static int maxDepthRecur(tnode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right));
  }

  public static int maxDepth(tnode root) {
    if (root == null) {
      return 0;
    }

    Queue<tnode> queue = new LinkedList<>();
    queue.add(root);
    int depth=0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i=0; i<size; i++) {
        tnode curr = queue.poll();
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
  // The minimum depth is the number of nodes along the shortest path from the root tnode to the nearest leaf tnode.
  public static int minDepth(tnode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return 1;
    }
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }

  // Function to print level order traversal of a given binary tree
  public static void levelOrderTraversal(tnode root) {
    // start from level 1 — till the height of the tree
    int level = 1;

    // run till printLevel() returns false
    while (printLevel(root, level)) {
      level++;
    }
  }

  public static int treeSum(tnode root) {
    if (root == null) {
      return 0;
    }

    return root.data + treeSum(root.left) + treeSum(root.right);
  }

  public static int treeSumIterative(tnode root) {
    Queue<tnode> queue = new LinkedList<>();

    if (root == null) {
      return 0;
    }

    int sum = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      tnode tnode = queue.poll();
      sum += tnode.data;
      if (tnode.left != null) {
        queue.add(tnode.left);
      }
      if (tnode.right != null) {
        queue.add(tnode.right);
      }
    }
    return sum;
  }

  public static int sumOfPathNumbers(tnode root) {
    if (root == null) {
      return 0;
    }
    return findPathSum(root, 0);
  }

  public static int findPathSum(tnode root, int pathSum) {
    if (root == null) {
      return 0;
    }

    pathSum = (10 * pathSum) + root.data;
    if (root.left == null & root.right == null) {
      return pathSum;
    }
    return findPathSum(root.left, pathSum) + findPathSum(root.right, pathSum);
  }

  public static int treeMin(tnode root) {
    if (root == null) {
      return -1;
    }

    Queue<tnode> queue = new LinkedList<>();
    queue.add(root);

    int min = root.data;
    while (!queue.isEmpty()) {
      tnode tnode = queue.poll();
      if (tnode.data < min) {
        min = tnode.data;
      }
      if (tnode.left != null) {
        queue.add(tnode.left);
      }
      if (tnode.right != null) {
        queue.add(tnode.right);
      }
    }

    return min;
  }

  public static int rootToLeafMax(tnode root) {
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
  public static int rootToLeafMaxIter(tnode root) {

    if (root == null) {
      return -1;
    }
    Queue<tnode> queue = new LinkedList<>();
    queue.add(root);

    int sum = 0;
    while (!queue.isEmpty()) {
      tnode tnode = queue.poll();
      sum += tnode.data;
      if (tnode.left != null && tnode.right != null) {
        if (tnode.left.data > tnode.right.data) {
          queue.add(tnode.left);
        }
      } else if (tnode.left != null) {
        queue.add(tnode.left);
      } else if (tnode.right != null) {
        queue.add(tnode.right);
      }
    }
    return sum;
  }

  public static boolean isSameTree(tnode p, tnode q) {
    if (p == null && q== null) {
      return true;
    } else if (p == null || q == null) {
      return false;
    }
    return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static int treeMax(tnode root) {
    if (root == null) {
      return -1;
    }
    int leftMax = treeMax(root.left);
    int rightMax = treeMax(root.right);

    return Math.max(Math.max(root.data, leftMax), rightMax);
  }

  public static int treeHeight(tnode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
  }

  public static boolean existsInTree(tnode root, int target) {
    if (root == null) {
      return false;
    }
    boolean leftFound = existsInTree(root.left, target);
    boolean rightFound = existsInTree(root.right, target);

    return root.data == target || leftFound || rightFound;
  }

  public static void mirrorTree(tnode root) {
    if (root == null) {
      return;
    }
    tnode temp = root.left;
    root.left = root.right;
    root.right = temp;
    mirrorTree(root.left);
    mirrorTree(root.right);
  }

  // Leetcode: 112 - Path Sum
  // find if the tree has a path from root-to-leaf such that the sum of all the tnode values of that path equals sum
  public static boolean hasPathSum(tnode root, int target) {
    if (root == null) {
      return false;
    }

    if (root.data == target && root.left == null && root.right == null) {
      return true;
    }

    return hasPathSum(root.left, target-root.data) || hasPathSum(root.right, target-root.data);
  }

  // Leetcode: 113 - PathSum II
  // return root-to-leaf paths where the sum is equal to a targetSum
  public static List<List<Integer>> pathSumII(tnode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    pathSum(root, targetSum, new ArrayList<>(), result);
    return result;
  }

  public static void pathSum(tnode root, int sum, List<Integer> path, List<List<Integer>> result) {
    if (root == null) {
      return;
    }
    path.add(root.data);
    if (root.left == null && root.right == null && sum == root.data) {
      result.add(path);
    }
    pathSum(root.left, sum-root.data, new ArrayList<>(path), result);
    pathSum(root.right, sum-root.data, new ArrayList<>(path), result);
  }

  public static void printTree(tnode root) {
    if (root == null) {
      return;
    }
    for (int level=1; level <= treeHeight(root); level++) {
      printCurrentLevel(root, level);
    }
  }

  public static void printCurrentLevel(tnode root, int level) {
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

  public static List<tnode> inOrder(tnode root, List<tnode> list) {
    if (root != null) {
      inOrder(root.left);
      list.add(root);
      inOrder(root);
    }
    return list;
  }

  public static tnode kthLargestNode(tnode root, int k) {
    if (root == null) {
      return null;
    }
    List<tnode> list = new ArrayList<>();
    list = inOrder(root, list);

    if (k>list.size()) {
      return null;
    }
    return list.get(list.size()-k);
  }
}
