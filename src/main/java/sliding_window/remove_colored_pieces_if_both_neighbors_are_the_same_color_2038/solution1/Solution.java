package sliding_window.remove_colored_pieces_if_both_neighbors_are_the_same_color_2038.solution1;

public class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0, b = 0;
        for (int i = 1; i < colors.length() - 1; ++i) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    a += 1;
                } else {
                    b += 1;
                }
            }
        }
        return a > b;
    }
}
