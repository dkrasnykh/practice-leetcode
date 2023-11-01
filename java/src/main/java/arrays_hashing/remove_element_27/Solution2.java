package arrays_hashing.remove_element_27;

//https://www.youtube.com/watch?v=Pcd1ii9P9ZI
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                ++k;
            }
        }
        return k;
    }

    public static void main(String[] args) {

    }
}
