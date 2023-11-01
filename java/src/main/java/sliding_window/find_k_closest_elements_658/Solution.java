package sliding_window.find_k_closest_elements_658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int d = 0, r = 0, s = 0, e = 0;
        int dmin = Integer.MAX_VALUE;
        for (int l = 0; l <= arr.length - k; ++l) {
            while (r - l < k) {
                d += Math.abs(arr[r] - x);
                r += 1;
            }
            if (d < dmin) {
                dmin = d;
                s = l;
                e = r;
            }
            d -= Math.abs(arr[l] - x);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = s; i < e; ++i) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(s.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        System.out.println(s.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
        System.out.println(s.findClosestElements(new int[]{0, 2, 2, 3, 4, 6, 7, 8, 9, 9}, 4, 5)); //[3,4,6,7]
    }
}
