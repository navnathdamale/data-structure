package com.ds.intro.heap;

public class Heapify {

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || array.length < k) throw new IllegalArgumentException();

        MaxHeap maxHeap = new MaxHeap();
        for (int i : array) {
            maxHeap.insert(i);
        }

        for (int j = 0; j < k - 1; j++) {
            maxHeap.remove();
        }

        return maxHeap.max();
    }

    public static void heapify(int[] array) {
        int lastParentIndex = (array.length / 2) - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int index) {
        int largeIndex = index;
        int leftIndex = (index * 2) + 1;
        int rightIndex = (index * 2) + 2;

        if (leftIndex < array.length && array[leftIndex] > array[largeIndex]) {
            largeIndex = leftIndex;
        }

        if (rightIndex < array.length && array[rightIndex] > array[largeIndex]) {
            largeIndex = rightIndex;
        }

        if (index == largeIndex) {
            return;
        }

        swap(array, index, largeIndex);
        heapify(array, largeIndex);
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
