package two_pointers.intersection_of_two_arrays_II_350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            while(j < nums2.length && nums1[i] >= nums2[j]){
                if(nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    j += 1;
                    break;
                }
                j += 1;
            }
            i += 1;
        }
        int[] answer = new int[list.size()];
        for(i = 0; i < list.size(); ++i){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
