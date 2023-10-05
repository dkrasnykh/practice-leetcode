package arrays_hashing.medianOfTwoSortedArrays;

/*
https://leetcode.com/problemset/all/?topicSlugs=array
#4. Median of Two Sorted Arrays
*/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        1. int[] both = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();

        2. int[] both = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, both, nums1.length, nums2.length);
        Arrays.sort(both);

        if (both.length % 2 == 0)
            return (double)(both[(both.length -1)/2] + both[(both.length)/2])/2;
        else
            return (double)both[both.length/2];
         */

        int i = 0;
        int j = 0;
        int k = 0;
        int m1 = 0;
        int m2 = 0;

        while(k < (nums1.length + nums2.length + 2)/2){
            if ((j < nums2.length && i < nums1.length && nums1[i] >= nums2[j]) || ((i == nums1.length && j < nums2.length))) {
                m1 = m2;
                m2 = nums2[j];
                j++;
                k++;
            } else if ((i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) || (j == nums2.length && i < nums1.length)) {
                m1 = m2;
                m2 = nums1[i];
                i++;
                k++;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0){
            return (double)(m1 + m2)/2;
        } else return (double) m2;
    }

}
