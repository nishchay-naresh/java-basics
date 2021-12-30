package com.nishchay.ds.design.median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 *============== Median in a stream of integers (running integers) ====================
 *
 *
 * Given that integers are read from a data stream. Find median of elements read so for in an efficient way.
 * For simplicity assume, there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …
 *
 *
 * Examples - 1
 *	After reading 1st element of stream - 5 -> median - 5
 *	After reading 2nd element of stream - 5, 15 -> median - 10
 *	After reading 3rd element of stream - 5, 15, 1 -> median - 5
 *	After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...
 *
 *
 * https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * https://www.baeldung.com/java-stream-integers-median-using-heap
 * */
class MedianOfIntegerStream {

    private Queue<Integer> leftHeap, rightHeap;

    MedianOfIntegerStream() {
        //  maxHeap : descending order sorting, peek() - will give max element
        leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
        //  minHeap : ascending order sorting, peek() - will give min element
        rightHeap = new PriorityQueue<>();
    }


    /*
     *
     * ================ Heap-based Approach =======================
     *
     *	1.	We must get the minimum/maximum element of a dataset in O(1) time
     *	2.	The elements don't have to be kept in a sorted order as long as we can get the minimum/maximum element efficiently
     *	3.	We need to find an approach for adding an element to our dataset that costs less than O(n) time
     *  we'll use the Heap data structure that helps us achieve our goals efficiently.
     *
     *	Max–heap Property - in a max-heap, the root node always has the largest value.
     *	Min–heap Property - in a min-heap, the root node always has the smallest value.
     *--------------------------------
     *	When we add a new integer, we have two scenarios:
     *
     *	1. Total no. of existing elements is even
     *		size(min-heap) == size(max-heap) == (n / 2)
     *
     *	2. Total no. of existing elements is odd
     *		size(max-heap) == (n / 2)
     *		size(min-heap) == (n / 2) + 1
     * */
    void add(int num) {
        if (rightHeap.size() == leftHeap.size()) {
            // Even count : add it to left first, then rebalanced to right
            leftHeap.offer(num);
            rightHeap.offer(leftHeap.poll());
        } else {
            // Odd count : add it to right first, then rebalanced to left
            rightHeap.offer(num);
            leftHeap.offer(rightHeap.poll());
        }
    }

    double getMedian() {
        double  median;
        if (rightHeap.size() > leftHeap.size()) {
            median = rightHeap.peek();
        } else {
            median = (double)(rightHeap.peek() + leftHeap.peek()) / 2;
        }
        return median;
    }
}