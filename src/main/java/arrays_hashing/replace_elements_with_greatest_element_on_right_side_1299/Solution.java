package arrays_hashing.replace_elements_with_greatest_element_on_right_side_1299;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[] replaceElements(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        for (Integer e : arr) {
            map.compute(e, (key, value) -> (value == null) ? 1 : value + 1);
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            if (map.get(arr[i]) == 1) {
                map.remove(arr[i]);
            } else {
                map.compute(arr[i], (key, value) -> value - 1);
            }
            arr[i] = map.entrySet().iterator().next().getKey();
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
        System.out.println(Arrays.toString(s.replaceElements(new int[]{400})));
    }
}
