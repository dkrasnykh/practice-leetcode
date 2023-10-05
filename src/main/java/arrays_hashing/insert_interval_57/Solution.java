package arrays_hashing.insert_interval_57;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> event = new ArrayList<>();
        event.add(new int[]{newInterval[0], -1});
        event.add(new int[]{newInterval[1], 1});
        for (int[] elem : intervals) {
            event.add(new int[]{elem[0], -1});
            event.add(new int[]{elem[1], 1});
        }
        event.sort((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        List<int[]> ansList = new ArrayList<>();
        int open = 0;
        int start = -1;
        for (int[] e : event) {
            int state = e[1];
            if (state == 1) {
                open -= 1;
                if (open == 0) {
                    ansList.add(new int[]{start, e[0]});
                    start = -1;
                }
            } else if (state == -1) {
                if (start == -1) {
                    start = e[0];
                }
                open += 1;
            }
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ans.length; ++i) {
            int[] e = ansList.get(i);
            ans[i][0] = e[0];
            ans[i][1] = e[1];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
