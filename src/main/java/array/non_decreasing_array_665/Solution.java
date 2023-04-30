package array.non_decreasing_array_665;

import java.util.Optional;
import java.util.TreeMap;

//Time Limit Exceeded
public class Solution {
    public boolean checkPossibility(int[] nums) {
        TreeMap<Integer, Integer> numsCnt = new TreeMap<>();
        boolean param1 = true;
        int cnt = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] > nums[i]) {
                cnt2 += 1;
            }
            Optional<Integer> greater = numsCnt.tailMap(nums[i], false)
                    .values()
                    .stream()
                    .reduce(Integer::sum);
            if (greater.isPresent() && greater.get() > 0) {
                cnt += 1;
            }
            if (greater.isPresent() && greater.get() > 1) {
                param1 = false;
            }
            numsCnt.compute(nums[i], (key, value) -> (value == null) ? 1 : value + 1);
        }
        return (cnt <= 1 || param1) && cnt2 <= 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkPossibility(new int[]{4, 2, 3})); //должен быть возрастающий порядок
        System.out.println(s.checkPossibility(new int[]{4, 2, 1}));
        //[3,4,2,3]
        System.out.println(s.checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(s.checkPossibility(new int[]{5, 7, 1, 8}));
        //[1,5,4,6,7,10,8,9]
        System.out.println(s.checkPossibility(new int[]{1, 5, 4, 6, 7, 10, 8, 9}));
    }
}
