package array.twoSum;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void twoSum() {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(result, new int[]{1, 2});

        result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(result, new int[]{0, 1});

        result = solution.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(result, new int[]{0,1});
        /*
        result = solution.twoSum(new int[]{}, 0);
        assertArrayEquals(result, null);
        */
    }
}