package two_pointers.merge_sorted_array_88;

//https://www.youtube.com/watch?v=P1Ic85RarKY
public class Solution3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];
                m -= 1;
            } else {
                nums1[last] = nums2[n - 1];
                n -= 1;
            }
            last -= 1;
        }
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n -= 1;
            last -= 1;
        }
    }

    public static void main(String[] args) {

    }
}
