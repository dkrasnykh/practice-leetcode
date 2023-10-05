package arrays_hashing.merge_intervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=44H3cEC2fFM
public class Solution1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        List<int[]> resultList = new ArrayList<>();
        resultList.add(intervals[0]);
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] <= resultList.get(resultList.size() - 1)[1]){
                resultList.get(resultList.size()-1)[1] = Math.max(intervals[i][1], resultList.get(resultList.size()-1)[1]);
            } else {
                resultList.add(intervals[i]);
            }
        }
        int[][] result = new int[resultList.size()][2];
        for(int i = 0; i < resultList.size(); ++i){
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }
        return result;
    }
}
