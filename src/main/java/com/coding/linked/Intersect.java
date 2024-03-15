package com.coding.linked;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 *    4->1
 *        \
 *         ->8->4->5
 *        /
 * 5->6->1
 */

public class Intersect {

  public static void main(String[] args) {
    node head1 = LinkedListUtil.construct(new int[]{4,1});
    node head2 = LinkedListUtil.construct(new int[]{5,6,1});
    node inter = LinkedListUtil.construct(new int[]{8,4,5});
    merge(head1, head2, inter);

    LinkedListUtil.print(head1);
    LinkedListUtil.print(head2);
    node merged = findIntersect(head1, head2);
    System.out.println("merged at node: " + (merged != null ? merged.data : null));
  }

  public static void merge(node head1, node head2, node inter) {
    node curr1 = head1;
    while (curr1.next != null) {
      curr1 = curr1.next;
    }
    node curr2 = head2;
    while (curr2.next != null) {
      curr2 = curr2.next;
    }

    curr1.next = inter;
    curr2.next = inter;
  }

  public static node findIntersect(node head1, node head2) {

    node curr1 = head1;

    while (curr1 != null) {
      node curr2 = head2;
      while (curr2 != null && curr1.next != curr2.next) {
        curr2 = curr2.next;
      }
      if (curr1 != null && curr2 != null && curr1.next == curr2.next) {
        return curr1.next;
      }
      curr1 = curr1.next;
    }
    return null;
  }

}
