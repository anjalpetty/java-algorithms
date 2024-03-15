package com.coding.linked;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 * e.g:
 * input : 1->2->3->4->5
 * output: 1->3->5->2->4
 *
 * input:  2->1->3->5->6->4->7
 * output: 2->3->6->7->1->5->4
 */

public class GroupOddEven {


  public static void main(String[] args) {
//    node head = LinkedListUtil.construct(new int[]{1,2,3,4,5});
    node head = LinkedListUtil.construct(new int[]{2,1,3,5,6,4,7});
    LinkedListUtil.print(head);
    head = OddOrEven(head);
    LinkedListUtil.print(head);
  }

  public static node OddOrEven(node head) {

    if (head == null) {
      return null;
    }

    node odd = head;
    node even = head.next;
    node eventail = even;
    while (eventail != null && eventail.next != null) {
      odd.next = eventail.next;
      eventail.next = eventail.next.next;
      odd.next.next = even;
      odd = odd.next;
      eventail = eventail.next;
    }
    return head;
  }
}
