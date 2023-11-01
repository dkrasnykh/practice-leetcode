package two_pointers.number_of_subsequences_that_satisfy_the_given_sum_condition_1498;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution3 {
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
                BigInteger two = new BigInteger("2");
                int p = r-l;
                BigInteger bians = two.modPow(new BigInteger(String.valueOf(p)), new BigInteger("1000000007"));
                ans += bians.longValue();
            }
        }
        return (int)(ans%1000000007);
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        //272187084
        //System.out.println(s.numSubseq(new int[]{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14}, 22));
        //504352365
        System.out.println(s.numSubseq(new int[]{27,5,27,19,3,2,22,22,18,30,26,2,27,6,30,13,24,20,14,8,9,18,28,28,9,18,15,14,29,15,28,4,18,5,25,11,6,23,19,25,19,22,10,13,28,4,6,7,4,11,22,25,29,4,14,29,7,9,2,3,15,29,10,24,7,28,9,13,1,9,9,26,27,12,28,12,24,16,19,17,30,28,15,15,28,25,12,9,11,17,30,23,26,21,17,1,17}, 37));
    }
}
