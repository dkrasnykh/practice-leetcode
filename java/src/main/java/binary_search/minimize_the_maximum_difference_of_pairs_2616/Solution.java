package binary_search.minimize_the_maximum_difference_of_pairs_2616;

import java.util.Arrays;

public class Solution {
    public boolean check(int[] sorted, int p, int d) {
        int p1 = 0;
        int i = 0;
        while(i < sorted.length - 1){
            if(Math.abs(sorted[i + 1] - sorted[i]) <= d){
                p1 += 1;
                i += 2;
            } else {
                i += 1;
            }
        }
        return p1 >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0, r = Math.abs(nums[nums.length - 1] - nums[0]);
        while(l <= r){
            int m = l + (r - l)/2;
            if(check(nums, p, m)){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
    }
}
