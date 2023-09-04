package array.interval_list_intersections_986;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> event = new ArrayList<>();
        for(int i = 0; i < firstList.length; ++i){
            event.add(new int[]{firstList[i][0], -1});
            event.add(new int[]{firstList[i][1], 1});
        }
        for(int i = 0; i < secondList.length; ++i){
            event.add(new int[]{secondList[i][0], -1});
            event.add(new int[]{secondList[i][1], 1});
        }
        Collections.sort(event, (e1,e2) -> (e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]));
        int start = -1, open = 0;
        List<int[]> res = new ArrayList<>();
        for(int[] e : event){
            int x = e[0];
            int state = e[1];
            if(state == -1){
                if(open > 0){
                    start = x;
                }
                open += 1;
            } else {
                if(start != -1){
                    res.add(new int[]{start, x});
                    start = -1;
                }
                open -= 1;
            }
        }
        int[][] a = new int[res.size()][2];
        for(int i = 0; i < res.size(); ++i){
            a[i][0] = res.get(i)[0];
            a[i][1] = res.get(i)[1];
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
