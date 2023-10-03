package sliding_window.remove_colored_pieces_if_both_neighbors_are_the_same_color_2038;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0, b = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < colors.length(); ++i) {
            map.compute(colors.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            if (i >= 2) {
                if (map.getOrDefault('A', 0) == 3) {
                    a += 1;
                } else if (map.getOrDefault('B', 0) == 3) {
                    b += 1;
                }
                map.compute(colors.charAt(i - 2), (k, v) -> v - 1);
            }
        }
        return a > b;
    }
}
