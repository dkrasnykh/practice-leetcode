package two_pointers.trapping_rain_water_42;

import java.util.Objects;
import java.util.TreeSet;

public class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public int trap(int[] height) {
        TreeSet<Pair> tree = new TreeSet<>((a, b) -> (a.first == b.first) ? a.second - b.second : b.first - a.first);
        long[] prefix = new long[height.length + 1];
        for (int i = 0; i < height.length; ++i) {
            tree.add(new Pair(height[i], i));
            prefix[i + 1] = prefix[i] + height[i];
        }
        int res = 0;
        int l = tree.first().second, r = tree.first().second;
        for (Pair e : tree) {
            if (e.second > r) {
                long tmp = (e.second - r - 1) * (long) (e.first) - (prefix[e.second] - prefix[r + 1]);
                res += (int)tmp;
                r = e.second;
            }
            if(e.second < l){
                long tmp = (l - e.second - 1) * (long)(e.first) - (prefix[l] - prefix[e.second + 1]);
                res += (int)tmp;
                l = e.second;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(s.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
