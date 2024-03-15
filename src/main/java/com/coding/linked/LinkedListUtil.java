package com.coding.linked;

import java.util.Stack;

public class LinkedListUtil {

  public static node createNode(int d) {
    return new node(d, null);
  }

  public static node construct(int[] arr) {
    node head = null;
    if (arr.length > 0) {
      head = new node(arr[0]);
      node curr = head;
      for (int i=1; i<arr.length; i++) {
        curr.next = new node(arr[i]);
        curr = curr.next;
      }
    }
    return head;
  }

  public static node deleteByValue(node head, int value) {
    if (head == null) {
      return null;
    }

    // if first node
    if (head.data == value) {
      return head.next;
    }

    node prev = head;      // points to head node
    node curr = head.next; // points to second node
    while (curr.next != null) {
      if (curr.data == value) {
        prev.next = curr.next;
        break;
      }
      prev = curr;
      curr = curr.next;
    }

    // if last node
    if (curr.next == null && curr.data == value) {
      prev.next = null;
    }
    return head;
  }

  // position starts from 0
  public static node deleteByPosition(node head, int position) {
    if (head == null) {
      return null;
    }

    // if first node
    if (position==0) {
      return head.next;
    }

    node prev = head;
    node curr = head.next;
    int count = 1;
    while (curr.next != null) {
      if (count++ != position) {
        prev = curr;
        curr = curr.next;
      } else {
        prev.next = curr.next;
        break;
      }
    }

    // if last node
    if (count == position) {
      prev.next = null;
    } else {
      System.out.println("invalid position: " + position);
    }
    return head;
  }

  public static node reverse(node head) {

    if (head == null) {
      return head;
    }
    node curr = head;
    Stack<node> stack = new Stack<>();
    while (curr!= null) {
      stack.push(curr);
      curr = curr.next;
    }

    head = stack.pop();
    curr = head;
    while (!stack.isEmpty()) {
      curr.next = stack.pop();
      curr = curr.next;
    }
    curr.next = null;

    return head;
  }

  public static node reverseNormal(node head) {
    node curr = head;
    node prev = null;
    node next = null;

    if (head == null) {
      return null;
    }

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
    return head;
  }

  public static void print(node head) {
    if (head == null) {
      System.out.println("list is empty");
      return;
    }
    node t = head;
    while (t != null) {
      if (t.next != null) {
        System.out.print(t.data + "->");
      } else {
        System.out.print(t.data);
        System.out.println("");
      }
      t = t.next;
    }
  }

  public static int length(node head) {
    node curr = head;
    int length = 0;
    if (head == null) {
      return length;
    }
    while (curr != null) {
      length++;
      curr = curr.next;
    }
    return length;
  }

  public static void sort(node head) {
    if (head == null) {
      return;
    }
    node curr = head;
    while (curr != null) {
      node iter = curr.next;
      while (iter != null) {
        if (curr.data > iter.data) {
          int t = curr.data;
          curr.data = iter.data;
          iter.data = t;
        }
        iter = iter.next;
      }
      curr = curr.next;
    }
  }

  public static void createLoop(node head) {
    node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = head;
  }

  // creating a cyle
  /*
     e.g:
     3 -> 2 -> 0 -> 4 -|
          ^            |
          |____________|
   */
  public static void createCycle(node head) {
    node curr = head;
    int index = 2;
    node prev = null;
    while (curr.next != null) {
      if (index-- == 0) {
        prev = curr;
      }
      curr = curr.next;
    }
    curr.next = prev;
  }
}
