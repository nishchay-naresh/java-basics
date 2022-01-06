package com.nishchay.ds.design.median;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQDemo {

    public static void main(String[] args) {

        heapPrint();
        System.out.println("----------------------------");
        maxHeapPrint();
        System.out.println("----------------------------");
        minHeapPrint();


    }

    private static void heapPrint() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(12);
        pq.offer(2);
        pq.offer(8);
        pq.offer(5);
        pq.offer(18);

        System.out.println("pq.size() = " + pq.size());
        Integer val = null;
        while ((val = pq.poll()) != null) {
            System.out.print(val + ", ");
        }
        System.out.println("\npq.size() = " + pq.size());
    }

    /*
     *	Max–heap Property - in a max-heap, the root node always has the largest value.
     *	Min–heap Property - in a min-heap, the root node always has the smallest value.
     * */
    private static void maxHeapPrint() {
        // Max–heap -  root node always has the largest value, keeps data in ascending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        maxHeap.offer(12);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(5);
        maxHeap.offer(18);

        System.out.println("maxHeap = " + maxHeap); // maxHeap = [2, 5, 8, 12, 18]
        System.out.println("maxHeap.peek() = " + maxHeap.peek());
    }

    private static void minHeapPrint() {
        // Min–heap -  root node always has the smallest value, keeps data in descending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap.offer(12);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(5);
        minHeap.offer(18);

        System.out.println("minHeap = " + minHeap); // minHeap = [18, 12, 8, 2, 5]
        System.out.println("minHeap.peek() = " + minHeap.peek());
    }
}
