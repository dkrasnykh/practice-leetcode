package array.group_the_people_given_the_group_size_they_belong_to_1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> open = new HashMap<>();
        for(int i = 0; i < groupSizes.length; ++i){
            if(open.containsKey(groupSizes[i])){
                open.get(groupSizes[i]).add(i);
            } else {
                open.put(groupSizes[i], new ArrayList<>(List.of(i)));
            }
            if(open.get(groupSizes[i]).size() == groupSizes[i]){
                result.add(open.remove(groupSizes[i]));
            }
        }
        return result;
    }
}
