package array.twoSum;

import java.util.Arrays;

public class Solution2 {
    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static void maxHeapify(int[] a, int[] ind, int i, int heapSize) {
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

            temp = ind[i];
            ind[i] = ind[largest];
            ind[largest] = temp;

            maxHeapify(a, ind, largest, heapSize);
        }
    }

    public static void buildMaxHeap(int[] a, int[] ind) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(a, ind, i, a.length);
        }
    }

    public static void heapsort(int[] a, int[] ind) {
        buildMaxHeap(a, ind);
        int heapSize = a.length;
        for (int i = a.length - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            temp = ind[0];
            ind[0] = ind[i];
            ind[i] = temp;
            heapSize--;
            maxHeapify(a, ind, 0, heapSize);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ind = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ind[i] = i;
        }
        heapsort(nums, ind);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                --r;
            } else if (nums[l] + nums[r] < target) {
                ++l;
            } else {
                return new int[]{ind[l], ind[r]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 3}, 6)));
    }
}
