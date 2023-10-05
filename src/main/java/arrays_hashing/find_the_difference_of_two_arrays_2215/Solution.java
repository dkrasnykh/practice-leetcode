package arrays_hashing.find_the_difference_of_two_arrays_2215;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<Integer> diff(int[] nums1, int[] nums2){
        List<Integer> answer1 = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < nums1.length; ++i){
            if(i!=0 && nums1[i] == nums1[i - 1]){
                continue;
            }
            boolean founded = false;
            while(j < nums2.length && nums1[i] >= nums2[j]){
                if(nums1[i] == nums2[j]){
                    founded = true;
                }
                ++j;
            }
            if(!founded){
                answer1.add(nums1[i]);
            }
        }
        return answer1;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> answer1 = diff(nums1, nums2);
        List<Integer> answer2 = diff(nums2, nums1);
        List<List<Integer>> answer = new ArrayList<>(List.of(answer1, answer2));
        return answer;
    }
}
