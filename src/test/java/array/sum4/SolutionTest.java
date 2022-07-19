package array.sum4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void fourSum() {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        assertEquals(list.get(0), new ArrayList<>(Arrays.asList(-2, 0, 0, 2)));
        assertEquals(list.get(1), new ArrayList<>(Arrays.asList(-2, -1, 1, 2)));
        assertEquals(list.get(2), new ArrayList<>(Arrays.asList(-1, 0, 0, 1)));

        assertEquals(solution.fourSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0).get(0), new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        assertEquals(solution.fourSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0).size(), 1);

        assertEquals(solution.fourSum(new int[]{1, 2, 3}, 3), new ArrayList<>(new ArrayList<>()));
    }
}