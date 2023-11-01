package math.line_reflection_356;

import java.util.*;

//не проверено на leetcode
public class Solution {
    public int getMedian(List<Integer> xs) {
        if (xs.size() % 2 == 1) {
            return 100000100;
        }
        Collections.sort(xs);
        int x = xs.get(0) + (xs.get(xs.size() - 1) - xs.get(0)) / 2;
        int l = 0;
        int r = xs.size() - 1;
        while (l < r) {
            if(x - xs.get(l) != xs.get(r) - x){
                return 100000100;
            }
            l += 1;
            r -= 1;
        }
        return x;
    }

    public boolean isReflected(int[][] points) {
        int inf = 100000100;
        Map<Integer, List<Integer>> yxs = new HashMap<>();
        for (int i = 0; i < points.length; ++i) {
            int x = points[i][0], y = points[i][1];
            List<Integer> xs = yxs.getOrDefault(y, new ArrayList<>());
            xs.add(x);
            yxs.put(y, xs);
        }
        Set<Integer> medians = new HashSet<>();
        for(Map.Entry<Integer, List<Integer>> e : yxs.entrySet()){
            medians.add(getMedian(e.getValue()));
        }
        return medians.size()==1 && medians.iterator().next() != inf;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isReflected(new int[][]{{1, 1}, {-1, 1}}));
        System.out.println(s.isReflected(new int[][]{{1, 1}, {-1, -1}}));
    }
}
