package com.nishchay.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapUsingPQ {

    public static void main(String[] args) {

        heapPrint();
        System.out.println("----------------------------");
        minHeapPrint();
        System.out.println("----------------------------");
        maxHeapPrint();

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
     *  Min–heap Property - in a min-heap, the root node always has the smallest value, keeps data in ascending order
     *	Max–heap Property - in a max-heap, the root node always has the largest value, keeps data in descending order
     * */
    private static void minHeapPrint() {
        // Min–heap -  root node always has the smallest value, keeps data in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(12);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(18);

        System.out.println("minHeap = " + minHeap); // minHeap = [1, 2, 8, 12, 5, 18]
        System.out.println("minHeap.peek() = " + minHeap.peek()); // 1

        printDataOrder(minHeap);
    }

    private static void maxHeapPrint() {
        // Max–heap -  root node always has the largest value, keeps data in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(12);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(18);

        System.out.println("maxHeap = " + maxHeap); // maxHeap = [18, 5, 12, 2, 1, 8]
        System.out.println("maxHeap.peek() = " + maxHeap.peek()); // 18

        printDataOrder(maxHeap);
    }

    private static void printDataOrder(Queue<Integer> heap) {
        System.out.print("heap data order - ");
        while(!heap.isEmpty()){
            System.out.print(heap.poll() + ", ");
        }
        System.out.println();
    }

}
