package sliding_window.find_k_closest_elements_658;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private int binsearch(int[] arr, int x){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            if(arr[m] <= x){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = binsearch(arr, x);
        int l = i;
        int r = i + 1;
        ArrayDeque<Integer> deq = new ArrayDeque();
        while(k > 0){
            if(l >= 0 && r < arr.length && Math.abs(arr[l] - x) <= Math.abs(arr[r] - x) || r == arr.length){
                deq.addFirst(arr[l]);
                l -= 1;
            } else {
                deq.addLast(arr[r]);
                r += 1;
            }
            k -= 1;
        }
        return new ArrayList(deq);
    }
}
