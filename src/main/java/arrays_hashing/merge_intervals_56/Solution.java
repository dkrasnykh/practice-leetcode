package arrays_hashing.merge_intervals_56;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> event = new ArrayList<>();
        for (int[] interval : intervals) {
            event.add(new int[]{interval[0], -1});
            event.add(new int[]{interval[1], 1});
        }
        event.sort((e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        int start = -1, open = 0;
        List<int[]> listResult = new ArrayList<>();
        for(int[] e : event){
            int x = e[0];
            int state = e[1];
            if(state == -1){
                if(open == 0){
                    start = x;
                }
                open += 1;
            } else {
                if(open == 1){
                    listResult.add(new int[]{start, x});
                }
                open -= 1;
            }
        }
        int[][] result = new int[listResult.size()][2];
        for(int i = 0; i < listResult.size(); ++i){
            result[i][0] = listResult.get(i)[0];
            result[i][1] = listResult.get(i)[1];
        }
        return result;
    }
}
