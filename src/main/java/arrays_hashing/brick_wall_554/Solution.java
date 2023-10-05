package arrays_hashing.brick_wall_554;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        List<int[]> event = new ArrayList<>();
        for (List<Integer> list : wall) {
            int lenght = 0;
            for (int i = 0; i < list.size() - 1; ++i) {
                lenght += list.get(i);
                event.add(new int[]{lenght, -1});
                event.add(new int[]{lenght, 1});
            }
        }
        event.sort((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        int open = wall.size();
        int ans = open;
        for(int[] e : event){
            open += e[1];
            ans = Math.min(open, ans);
        }
        return ans;
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
