package arrays_hashing.candy_135;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int candy(int[] ratings) {
        /*
        1) [1, 0, 2] -> 5
        2) [1, 2, 2] -> 4
        3) [5] -> 1
        4) [1,3,5,2,0] -> 9
        5) [1,2,5,4,3,1] -> 13
        */
        //20100
        if (ratings.length == 1) return 1;
        int inf = 20100;
        int result = 0, k = 0, cost = 1;
        while(k < ratings.length){
            List<Integer> inds = new ArrayList<>();
            for(int i = 0; i < ratings.length; ++i){
                if (ratings[i] == inf) continue;
                if(i==0 && ratings[i] <= ratings[i + 1]
                        || i==ratings.length-1 && ratings[i] <= ratings[i-1]
                        || i > 0 && i < ratings.length-1 && ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
                    result += cost;
                    inds.add(i);
                    k += 1;
                }
            }
            for(Integer i : inds){
                ratings[i] = inf;
            }
            cost += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.candy(new int[]{1,0,2}));
    }
}
