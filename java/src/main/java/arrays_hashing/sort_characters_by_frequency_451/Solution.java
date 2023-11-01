package arrays_hashing.sort_characters_by_frequency_451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String frequencySort(String s) {
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
            length = Math.max(length, map.get(c));
        }
        length += 1;
        List<Character>[] arr = new List[length];
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (arr[e.getValue()] == null) {
                arr[e.getValue()] = new ArrayList<>(List.of(e.getKey()));
            } else {
                arr[e.getValue()].add(e.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; --i) {
            if (arr[i] != null) {
                for (Character c : arr[i]) {
                    for (int j = 0; j < i; ++j) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.frequencySort("tree"));
    }
}
