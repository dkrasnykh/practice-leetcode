package arrays_hashing.replace_elements_with_greatest_element_on_right_side_1299;

import java.util.Arrays;

public class Solution2 {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1;
        int newMax;
        for (int i = arr.length - 1; i >= 0; --i) {
            newMax = Math.max(rightMax, arr[i]);
            arr[i] = rightMax;
            rightMax = newMax;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(Arrays.toString(s.replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
        System.out.println(Arrays.toString(s.replaceElements(new int[]{400})));
    }
}
