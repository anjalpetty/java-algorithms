package com.coding.linked;

/**
 Leetcode: 2
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
    /*node head1 = LinkedListUtil.construct(new int[]{2, 4, 3});
    LinkedListUtil.print(head1);
    node head2 = LinkedListUtil.construct(new int[]{5, 6, 4});*/

    node head1 = LinkedListUtil.construct(new int[]{9, 9, 9, 9, 9, 9, 9});
    LinkedListUtil.print(head1);
    node head2 = LinkedListUtil.construct(new int[]{9, 9, 9, 9});

    LinkedListUtil.print(head2);
    node head3 = addSum(head1, head2);
    LinkedListUtil.print(head3);
  }

  public static node addSum(node l1, node l2) {
    node result = new node(-1);
    node head = result;
    int carry = 0;
    int val1, val2;
    int sum;
    while (l1 != null || l2 != null) {
      val1 = l1 == null ? 0: l1.data;
      val2 = l2 == null ? 0: l2.data;

      sum = val1 + val2 + carry;
      if (sum == 10) {
        sum = 0; carry = 1;
      } else if (sum > 10) {
        carry = sum / 10;
        sum -= 10;
      } else {
        carry = 0;
      }
      result.next = new node(sum);
      result = result.next;
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }
    if ( carry > 0) {
      result.next = new node(carry);
    }
    return head.next;
  }

}
