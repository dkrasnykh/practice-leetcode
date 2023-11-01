package two_pointers.number_of_subsequences_that_satisfy_the_given_sum_condition_1498;

import java.util.Arrays;

//TL 61 test case
public class Solution2 {
    static int rbinsearch(int l, int r, int param, int[] a) {
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (a[m] <= param) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        if (a[l] <= param) {
            return l;
        } else {
            return -1;
        }
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = 0;
        int r = rbinsearch(0, nums.length - 1, target - nums[0], nums);
        if (r == -1) {
            return 0;
        }
        for (int l = 0; l < nums.length; ++l) {
            r = Math.max(l, r);
            while (l<=r && nums[l] + nums[r] > target) {
                r -= 1;
            }
            if(l==r && nums[l]*2<=target){
                ans+=1;
            } else if (l<r){
                int p = r-l;
                int p1 = p/31;
                int p2 = p%31;
                long ans1 = 1;
                for(int j = 0; j<p1; ++j){
                    ans1 = (ans1%1000000007 * (1L<<31)%1000000007)%1000000007;
                }
                ans1 = (ans1%1000000007 * (1L<<p2)%1000000007)%1000000007;
                //ans += (1L <<(r-l));
                ans += ans1;
            }
        }
        return (int)(ans%1000000007);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        /*
        System.out.println(s.numSubseq(new int[]{3,5,6,7}, 9));
        System.out.println(s.numSubseq(new int[]{3,3,6,8}, 10));
        System.out.println(s.numSubseq(new int[]{2,3,3,4,6,7}, 12));
        */
        //272187084
        System.out.println(s.numSubseq(new int[]{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14}, 22));
    }
}
