package arrays_hashing.number_of_pairs_of_interchangeable_rectangles_2001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < rectangles.length; ++i){
            Long key = (long)((double)rectangles[i][0]/rectangles[i][1]*100000000);
            map.compute(key, (k,v)->(v==null)?1:v+1);
        }
        long total = 0;
        for(Map.Entry<Long, Long> e : map.entrySet()){
            total += (e.getValue()*(e.getValue() - 1))/2;
        }
        return total;
    }
}
