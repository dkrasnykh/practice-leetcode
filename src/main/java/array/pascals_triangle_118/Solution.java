package array.pascals_triangle_118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Collections.singletonList(1)));
        for (int length = 2; length <= numRows; ++length) {
            List<Integer> row = new ArrayList<>(length);
            row.add(ans.get(length - 2).get(0));
            for (int i = 1; i < length - 1; ++i) {
                row.add(ans.get(length - 2).get(i - 1) + ans.get(length - 2).get(i));
            }
            row.add(ans.get(length - 2).get(length - 2));
            ans.add(row);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.generate(2);
        for(List<Integer> a : res){
            System.out.println(a.toString());
        }
    }
}
