package array.containerWithMostWater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxArea() {
        Solution solution = new Solution();
        int maxArea = solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        assertEquals(maxArea, 49);

    }
}