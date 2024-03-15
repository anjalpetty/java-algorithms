package com.coding.heap;

import java.util.Arrays;

/*
  heap[(i-1)/2] Returns the parent node.
  heap[(2*i)+1] Returns the left child node.
  heap[(2*i)+2] Returns the right child node.
 */
public class MaxHeap {

  private int[] heap;
  private int size;

  public MaxHeap(int maxSize) {
    heap = new int[maxSize];
    size = 0;
  }

  // Returning position of parent
  private int parent(int pos) { return (pos - 1) / 2; }

  // Returning left children
  private int leftChild(int pos) { return (2 * pos) + 1; }

  // Returning right children
  private int rightChild(int pos){ return (2 * pos) + 2; }

  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  // O(log N)
  public void add(int data) {
    /*if (heap == null) {
      heap = new int[1];
      heap[0] = data;
    } else {
      int size = heap.length;
      heap = Arrays.copyOf(heap, size + 1);
      heap[size] = data;
      heapifyUp();
    }*/
    heap[size] = data;

    // traverse up and fix violated property
    int current = size;
    while (heap[current] > heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
    size++;
  }

  // O(log N)
  public int poll() {
    int popped = heap[0];
    heap[0] = heap[--size];
    maxHeapify(0);
    return popped;
  }

  public int peek() {
    if (size >= 0) {
      return heap[size-1];
    }
    return -1;
  }

  public void maxHeapify(int pos) {
    if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
      if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
        swap(pos, leftChild(pos));
        maxHeapify(leftChild(pos));
      } else {
        swap(pos, rightChild(pos));
        maxHeapify(rightChild(pos));
      }
    }
  }

  public void print() {
    for (int i=0; i < size/2; i++) {
      System.out.print("[" + heap[i] + "] ");
      if (leftChild(i) < size) {
        System.out.print(">" + heap[leftChild(i)] + " ");
      }
      if (rightChild(i) < size) {
        System.out.print(">>" + heap[rightChild(i)] + " ");
      }
    }
  }

  public boolean isEmpty() {
    return size > 0 ? false : true;
  }

  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap(5);
    maxHeap.add(5);
    maxHeap.add(3);
    maxHeap.add(17);
    maxHeap.add(10);
    maxHeap.add(84);
    maxHeap.print();

    System.out.println("");
    System.out.println("popped: " + maxHeap.poll());
    maxHeap.print();

    System.out.println("");
    System.out.println("peek: " + maxHeap.peek());
  }
}
