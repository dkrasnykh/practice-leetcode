package arrays_hashing.sort_an_array_912;

import java.util.Arrays;

public class Solution {
    private int left(int i) {
        return 2 * i;
    }
    private int right(int i) {
        return 2 * i + 1;
    }
    private void maxHeapify(int[] a, int i, int heapSize) {
        int l = left(i + 1) - 1;
        int r = right(i + 1) - 1;
        int largest;
        if (l < heapSize && a[l] > a[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            maxHeapify(a, largest, heapSize);
        }
    }
    private void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }
    private void heapsort(int[] a) {
        buildMaxHeap(a);
        int heapSize = a.length;
        for (int i = a.length - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapSize--;
            maxHeapify(a, 0, heapSize);
        }
    }
    public int[] sortArray(int[] nums) {
        heapsort(nums);
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortArray(new int[]{5,2,3,1})));
        System.out.println(Arrays.toString(s.sortArray(new int[]{-1, 5, -1, -1, 2,3,-5, 1})));
    }
}
