package com.nishchay.ds.design.median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianOfIntegerStream {

    private Queue<Integer> leftHeap, rightHeap;

    MedianOfIntegerStream() {
        //  maxHeap : descending order sorting, peek() - will give max element
        leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
        //  minHeap : ascending order sorting, peek() - will give min element
        rightHeap = new PriorityQueue<>();
    }


    /*
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