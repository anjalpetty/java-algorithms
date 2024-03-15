package com.coding.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapExample {

  public static void main(String args[]) {

    // Creating empty priority queue
    PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // min heap - natural order
//    PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder()); // max heap - reverse order

    // Adding items to the pQueue using add()
    pQueue.add(5);
    pQueue.add(3);
    pQueue.add(17);
    pQueue.add(10);
    pQueue.add(84);

    // Printing the top element of PriorityQueue
//    System.out.println(pQueue.peek());

    // Printing the top element and removing it
    // from the PriorityQueue container
//    System.out.println(pQueue.poll());

    System.out.println("all elements");
    while (!pQueue.isEmpty()) {
      System.out.print(pQueue.poll() + " ");
    }
  }
}
