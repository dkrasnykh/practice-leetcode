package array.sum3Closest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void threeSumClosest() {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};
        assertEquals(solution.threeSumClosest(nums, 1), 2);
    }
}