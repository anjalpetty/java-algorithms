package com.coding.linked;

import java.util.PriorityQueue;

import static com.coding.linked.LinkedListUtil.createLoop;

public class LinkedListProblems {

  public static void main(String[] args) {
    int[] nums = {7, 3, 8, 9, 1, 0};
    node head = LinkedListUtil.construct(nums);

    System.out.println(">> original");
    LinkedListUtil.print(head);
    LinkedListUtil.sort(head);
    System.out.println(">> sorted");
    LinkedListUtil.print(head);
    insertSorted(head, LinkedListUtil.createNode(7));
    System.out.println(">> insert 7 to sorted");
    LinkedListUtil.print(head);

    System.out.println(">> middle element of a list");
    middle(head);

    System.out.println(">> kthFromLast: " + kthFromLast(head, 3));

    System.out.println(">> reversedK, with k=3");
    head=reverseK(head, 3);
    LinkedListUtil.print(head);

    System.out.println(">> removeDuplicates");
    head = removeDup(head);
    LinkedListUtil.print(head);

    node head1 = LinkedListUtil.construct(new int[]{1,2,4});
    node head2 = LinkedListUtil.construct(new int[]{1,3,4});
    System.out.println(">> merge two sorted list");
    LinkedListUtil.print(head1);
    LinkedListUtil.print(head2);
    node merged = merge(head1, head2);
    LinkedListUtil.print(merged);

    System.out.println(">> merge k sorted list");
    node[] list = new node[]{
      LinkedListUtil.construct(new int[]{1,4, 5}),
      LinkedListUtil.construct(new int[]{1,3,4}),
      LinkedListUtil.construct(new int[]{2,6})};
    for (node n: list) {
      LinkedListUtil.print(n);
    }
    System.out.println(">> using minHeap priority Queue");
    node mergedK = mergeKLists(list);
    LinkedListUtil.print(mergedK);
    System.out.println(">> using divide and conquer");
    mergedK = mergeKLists(list, 0, list.length-1);
    LinkedListUtil.print(mergedK);

    System.out.println(">> reverseIterative - by link");
    head = reverse(head);
    LinkedListUtil.print(head);

    System.out.println(">> reverseRecursive - by link");
    head = reverseByLink(head);
    LinkedListUtil.print(head);

    System.out.println(">> reverseRecursive - by data");
    reverseByData(head);
    LinkedListUtil.print(head);

    System.out.println(">> remove cycle");
    removeCycle(head);
    LinkedListUtil.print(head);

    System.out.println(">> delete by value");
    head = LinkedListUtil.deleteByValue(head, 9);
    LinkedListUtil.print(head);

    System.out.println(">> delete by position");
    head = LinkedListUtil.deleteByPosition(head, 9);
    LinkedListUtil.print(head);

    System.out.println(">> modifyGroupEvenOdd");
    head = modifyGroupEvenOdd(head);
    LinkedListUtil.print(head);

    System.out.println(">> length of a cyclic list: " + lengthCycle(head));

  }

  public static void insertSorted(node head, node n) {
    node curr = head;
    if (head == null) {
      return;
    }
    node prev = curr;
    while (curr != null && curr.data < n.data) {
      prev = curr;
      curr = curr.next;
    }
    // check if we reached tail
    if (curr.next == null) {
      prev.next = n;
      return;
    }
    node t = prev.next;
    prev.next = n;
    n.next = t;
  }

  // find the middle element of a single linked list without iterating more than once
  // O(n)
  public static void middle(node head) {
    node slow = head;
    node fast = head;

    if (head == null) {
      return;
    }
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    System.out.println("middle node: " + slow.data);
  }


  // k-th element from last in single iteration
  public static int kthFromLast(node head, int k) {
    node slow = head;
    node fast = head;

    for (int i=0; i<k && fast != null; i++) {
      fast = fast.next;
    }

    while (fast!= null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow.data;
  }

  // remove duplicates from sorted list
  // time complexity : linear
  // space complexity : constant
  public static node removeDup(node head) {
    if (head == null) {
      return head;
    }
    node newList = new node(head.data);
    node curr = newList;
    while (head != null) {
      int val = head.data;
      removeHead(head);

      if (val != curr.data) {
        curr.next = new node(val);
        curr = curr.next;
      }
      head = head.next;
    }
    return newList;
  }

  // merge two sorted list and return a single sorted list.
  public static node merge(node l1, node l2) {

    if (l1 == null && l2 == null) {
      return null;
    } else if (l1 == null && l2 != null) {
      return l2;
    } else if (l1 != null && l2 == null) {
      return l1;
    }

    node dummy = new node(0);
    node curr = dummy;

    while (l1 != null && l2 != null) {
      if (l1.data < l2.data) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }

    if (l1 != null) {
      curr.next = l1;
    } else if (l2 != null) {
      curr.next = l2;
    }
    return dummy.next;
  }

  // leetcode 23. Merge k Sorted Lists
  // using min heap priority queue
  public static node mergeKLists(node[] lists) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int i=0; i<lists.length; i++) {
      node curr = lists[i];
      while (curr != null) {
        priorityQueue.add(curr.data);
        curr = curr.next;
      }
    }

    node dummy = new node(0);
    node head = dummy;
    while (!priorityQueue.isEmpty()) {
      dummy.next = new node(priorityQueue.remove());
      dummy = dummy.next;
    }
    return head.next;
  }

  // leetcode 23. Merge k Sorted Lists
  // using divide and conquer approach
  // O(N * log(K)), space O(K)
  public static node mergeKLists(node[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }
    int mid = start + (end-start)/2;
    node leftSide = mergeKLists(lists, start, mid);
    node rightSide = mergeKLists(lists, mid+1, end);

    return merge(leftSide, rightSide);
  }

  // reverse first k positions only
  // input 1->2->3->4->5->6->7->null
  // k=3
  // output 3->2->1->4->5->6->7->null
  public static node reverseK(node head, int k) {
    if (head == null) {
      return null;
    }

    node reversed = null;
    node reversedTail = null;
    for (int i=0; i<k && head!=null; i++) {
      if (reversed == null) {
        reversed = new node(head.data);
        reversedTail = reversed;
      } else {
        node temp = new node(head.data);
        temp.next = reversed;
        reversed = temp;
      }
      head = removeHead(head);
    }
    reversedTail.next = head;
    return reversed;
  }

  // reverse iterative solution
  public static node reverse(node head) {
    if (head == null) return head;

    node prev = null;
    node curr = head;
    node next = null;

    while (curr !=null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  // reverse recursive
  public static node reverseByLink(node head) {
    if (head == null) {
      return head;
    }
    // last node or only one node
    if (head.next == null) {
      return head;
    }
    node rest = reverseByLink(head.next);
    head.next.next = head;
    head.next = null; // set the tail
    return rest; // new head reversed
  }

  // reverse
  static node rleft;
  public static void reverseByData(node head) {
//    if (head == null) {
//      return;
//    }
//    reverseByData(head.next);
//    rleft = head;
//    int temp = head.data;
//    head.data = temp;
//    rleft.data = temp;
  }

  public static node removeHead(node head) {
    if (head == null) {
      return head;
    } else {
      return head.next;
    }
  }
  // convert bintree into a double linked list


  public boolean hasCycle(node head) {

    LinkedListUtil.createCycle(head);// create a cycle for testing
    if (head == null || head.next == null) {
      return false;
    }
    node slow = head;
    node fast = head.next.next;
    while (slow != null && fast != null && fast.next != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }

  // remove cycle from a linked list
  public static void removeCycle(node head) {

    if (head == null) {
      return;
    }
    // tail.next point to head
    createLoop(head);
    node slow = head;
    node fast = head;
    while (fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      // check if loop exists
      if (slow == fast) {
        break;
      }
    }

    // if no loop
    if (fast.next == null) {
      return;
    }

    // loop till both slow and fast reference one short of start of the loop
    slow = head;
    fast = head;
    while (slow.next != fast.next.next) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // remove the loop by setting slow.next as null
    slow.next = null;
  }

  // delete all odd positioned nodes from a circular linked list
  public static void deleteOddFromCircular(node head) {

    if (head == null) {
      return;
    }
    // tail.next point to head
    createLoop(head);
  }

  // given a 2-D matrix. convert into a linked list matrix. Link next right and down, print it

  public static void twoDmatrix() {

  }

  // Modify all even numbers before odd, keep the even and odd numbers order intact.
  public static node modifyGroupEvenOdd(node head) {
    if (head == null) {
      return null;
    }

    node evenStart = null;
    node evenEnd = null;
    node oddStart = null;
    node oddEnd = null;

    for (node curr = head; curr != null; curr = curr.next) {
      if (curr.data % 2 == 0) { // if even
        if (evenStart == null) {
          evenStart = curr;
          evenEnd = evenStart;
        } else {
          evenEnd.next = curr;
          evenEnd = evenEnd.next;
        }
      } else {
        if (oddStart == null) {
          oddStart = curr;
          oddEnd = oddStart;
        } else {
          oddEnd.next = curr;
          oddEnd = oddEnd.next;
        }
      }
    }

    // add odd list after eeven list
    evenEnd.next = oddStart;
    oddEnd.next = null;

    // modify head pointer
    head = evenStart;
    return head;
  }

  // length of a linked list which contains a cycle
  public static int lengthCycle(node head) {

    int len = 0;
    if (head == null) {
      return len;
    }

    // tail.next point to head
    createLoop(head);

    node slow = head;
    node fast = head;

    while (fast.next != null) {
      len++;
      fast = fast.next.next;
      slow = slow.next;

      // check if loop exists
      if (slow == fast) {
        break;
      }
    }
    return len;
  }

  // two lists of varying length that merge at a point. Find the merging point


}
