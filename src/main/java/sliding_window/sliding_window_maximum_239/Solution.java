package sliding_window.sliding_window_maximum_239;

import java.util.Arrays;
import java.util.Objects;
import java.util.TreeSet;

public class Solution {
    class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return value == pair.value && index == pair.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, index);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        TreeSet<Pair> window = new TreeSet<>((a, b) -> (a.value == b.value) ? a.index - b.index : b.value - a.value);
        int l = 0, r = 0;
        for (; r < k - 1; ++r) {
            window.add(new Pair(nums[r], r));
        }
        for (; r < nums.length; ++r) {
            window.add(new Pair(nums[r], r));
            res[l] = window.first().value;
            window.remove(new Pair(nums[l], l));
            l += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
