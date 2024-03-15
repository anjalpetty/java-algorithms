package com.coding.linked;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * e.g
 *   2->4->3
 * + 5->6->4
 * -----------
 *   7->0->8
 * -----------
 * ie: 342 + 465 => 708
 */

public class AddTwoList {


  public static void main(String[] args) {
    node head1 = LinkedListUtil.construct(new int[]{2, 4, 3});
    LinkedListUtil.print(head1);
    node head2 = LinkedListUtil.construct(new int[]{5, 6, 4});

    LinkedListUtil.print(head2);
    node head3 = addSum(head1, head2);
    LinkedListUtil.print(head3);
  }

  public static node addSum(node head1, node head2) {
    node curr1 = head1;
    node curr2 = head2;
    node head3 = null;
    node curr3 = head3;
    int carry = 0;
    while (curr1 != null && curr2 != null) {
      int sum = curr1.data + curr2.data + carry;
      if (sum > 9) {
        carry = sum / 10;
        sum = sum % 10;
      }
      if (head3 == null) {
        head3 = new node(sum);
        curr3 = head3;
      } else {
        curr3.next = new node(sum);
        curr3 = curr3.next;
      }
      curr1 = curr1.next;
      curr2 = curr2.next;
    }

    while (curr1 != null) {
      int sum = curr1.data + carry;
      if (sum > 9) {
        carry = sum / 10;
        sum = sum % 10;
      }
      if (head3 == null) {
        head3 = new node(sum);
        curr3 = head3;
      } else {
        curr3.next = new node(sum);
        curr3 = curr3.next;
      }
      curr1 = curr1.next;
    }

    while (curr2 != null) {
      int sum = curr2.data + carry;
      if (sum > 9) {
        carry = sum / 10;
        sum = sum % 10;
      }
      if (head3 == null) {
        head3 = new node(sum);
        curr3 = head3;
      } else {
        curr3.next = new node(sum);
        curr3 = curr3.next;
      }
      curr2 = curr2.next;
    }
    return head3;
  }

}
