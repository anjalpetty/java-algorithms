package com.coding.heap;

import java.util.PriorityQueue;

/*
Design a class to calculate the median of a number stream. The class should have the following two methods:

insertNum(int num): stores the number in the class
findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
Example 1:

1. insertNum(3)
2. insertNum(1)
3. findMedian() -> output: 2
4. insertNum(5)
5. findMedian() -> output: 3
6. insertNum(4)
7. findMedian() -> output: 3.5
 */
public class MedianNumberStream {

  public static void main(String[] args) {
    MedianNumberStream medianOfAStream = new MedianNumberStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }

  PriorityQueue<Integer> maxHeap; //containing first half of numbers
  PriorityQueue<Integer> minHeap; //containing second half of numbers

  public MedianNumberStream() {
    maxHeap = new PriorityQueue<>((a, b) -> b - a);
    minHeap = new PriorityQueue<>((a, b) -> a - b);
  }

  // time complexity - O(log N)
  public void insertNum(int num) {
    if (maxHeap.isEmpty() || maxHeap.peek() >= num)
      maxHeap.add(num);
    else
      minHeap.add(num);

    // either both the heaps will have equal number of elements or max-heap will have one
    // more element than the min-heap
    if (maxHeap.size() > minHeap.size() + 1)
      minHeap.add(maxHeap.poll());
    else if (maxHeap.size() < minHeap.size())
      maxHeap.add(minHeap.poll());
  }

  // time complexity - O(1)
  public double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      // we have even number of elements, take the average of middle two elements
      return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
    }
    // because max-heap will have one more element than the min-heap
    return maxHeap.peek();
  }
}
