package com.coding.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
  297. Serialize and Deserialize Binary Tree

      1
     / \
    2   3
       / \
      4   5

  Input: root = [1,2,3,null,null,4,5]
  Output: [1,2,3,null,null,4,5]

  Input: root = []
  Output: []
 */
public class SerializeDeserializeTree {

  public static void main(String[] args) {
    node root = new node(1);
    root.left = new node(2);
    root.right = new node(3);
    root.right.left = new node(4);
    root.right.right = new node(5);

    System.out.println("serialized: " + serialize(root));

    node root1 = deserialize(serialize(root));
    PrintTree.print("", root1, false);
  }

  // Encodes a tree to a single string.
  public static String serialize(node root) {
    String serialized = "";
    if (root == null) {
      return "";
    }
    Queue<node> queue = new LinkedList<>();
    queue.add(root);
    int nullCount = 0;
    while (!queue.isEmpty()) {
      while (nullCount > 0) {
        serialized = serialized + "null" + ",";
        nullCount--;
      }
      int size = queue.size();
      for (int i=0; i<size; i++) {
        node curr = queue.poll();
        serialized = serialized + curr.data + ",";

        if (curr.left != null) {
          queue.add(curr.left);
        } else {
          nullCount++;
        }
        if (curr.right != null) {
          queue.add(curr.right);
        } else {
          nullCount++;
        }
      }
    }
    return serialized.substring(0, serialized.length()-1);
  }

  // Decodes your encoded data to tree.
  public static node deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
    String[] arr = data.split(",");
    node root = new node(Integer.parseInt(arr[0]));

    for (int i=1; i<arr.length; i+=2) {
      if (arr[i].equals("null")) {
        root.left = null;
      } else {
        root.left = null;
      }
    }
    return root;
  }
}
