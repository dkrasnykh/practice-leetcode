package array.the_k_weakest_rows_in_a_matrix_1337;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    private int cnt(int[] row){
        int l = 0, r = row.length - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            if(row[m] == 1){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < mat.length; ++i){
            list.add(new int[]{cnt(mat[i]), i});
        }
        Collections.sort(list, (e1, e2) -> (e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]));
        int[] result = new int[k];
        for(int i = 0; i < k; ++i){
            result[i] = list.get(i)[1];
        }
        return result;
    }
}
