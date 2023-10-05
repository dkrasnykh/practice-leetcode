package arrays_hashing.find_the_difference_of_two_arrays_2215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> answer1 = new ArrayList<>();
        List<Integer> answer2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Arrays.stream(nums1).forEach(set1::add);
        Arrays.stream(nums2).forEach(set2::add);
        for(int i = 0; i < nums1.length; ++i){
            if(i!=0 && nums1[i] == nums1[i-1]){
                continue;
            }
            if(!set2.contains(nums1[i])){
                answer1.add(nums1[i]);
            }
        }
        for(int i = 0; i < nums2.length; ++i){
            if(i!=0 && nums2[i] == nums2[i-1]){
                continue;
            }
            if(!set1.contains(nums2[i])){
                answer2.add(nums2[i]);
            }
        }
        return new ArrayList<>(List.of(answer1, answer2));
    }
}
