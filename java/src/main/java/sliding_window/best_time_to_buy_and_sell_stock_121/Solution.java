package sliding_window.best_time_to_buy_and_sell_stock_121;

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

    public int maxProfit(int[] prices) {
        TreeSet<Pair> tree = new TreeSet<>((a, b) -> a.first == b.first ? a.second - b.second : b.first - a.first);
        for (int i = 0; i < prices.length; ++i) {
            tree.add(new Pair(prices[i], i));
        }
        int max = 0;
        for (int i = 0; i < prices.length-1; ++i) {
            tree.remove(new Pair(prices[i], i));
            max = Math.max(max, tree.first().first - prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));
    }
}
