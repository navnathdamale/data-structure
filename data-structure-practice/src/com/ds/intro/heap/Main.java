package com.ds.intro.heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(50);
        maxHeap.remove();

        maxHeap.print();

        int[] numbers = {1, 2, 3, 4, 5, 6};

        MaxHeap maxHeap1 = new MaxHeap();
        for (int i : numbers) {
            maxHeap1.insert(i);
        }
        maxHeap1.print();


        while (!maxHeap1.isEmpty()) {
            System.out.println(" " + maxHeap1.remove());
        }

        System.out.println(Arrays.toString(numbers));

        Heapify.heapify(numbers);

        System.out.println(Arrays.toString(numbers));

        System.out.println(Heapify.getKthLargest(numbers, 6));

        int[] numbers1 = {6, 5, 4, 3, 2, 1};

        MinHeap minHeap = new MinHeap(10);
        for (int i : numbers1) {
            minHeap.insert(i);
        }

        minHeap.print();

        while (!minHeap.isEmpty()) {
            System.out.println("\n " + minHeap.remove());
        }

    }
}