package array.sum3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void threeSum() {
        Solution solution = new Solution();

        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(result.get(0), new ArrayList<>(Arrays.asList(-1, -1, 2)));
        assertEquals(result.get(1).equals(new ArrayList<>(Arrays.asList(-1, 0, 1))), true);

        result = solution.threeSum(new int[]{0, 0, 0, 0});
        assertEquals(result.get(0), new ArrayList<>(Arrays.asList(0, 0, 0)));

        result = solution.threeSum(new int[]{1, 2, -2, -1});
        assertEquals(result, new ArrayList<>());
    }
}