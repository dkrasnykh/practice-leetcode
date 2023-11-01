package arrays_hashing.brick_wall_554;

import java.util.*;

//https://www.youtube.com/watch?v=Kkmv2h48ekw
public class Solution2 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> gaps = new HashMap<>();
        int maxgaps = 0;
        for (List<Integer> list : wall) {
            int lenght = 0;
            for (int i = 0; i < list.size() - 1; ++i) {
                lenght += list.get(i);
                gaps.compute(lenght, (key, value) -> (value == null) ? 1 : value + 1);
                maxgaps = Math.max(maxgaps, gaps.get(lenght));
            }
        }
        return wall.size() - maxgaps;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        //[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
        System.out.println(s.leastBricks(wall));

    }
}
