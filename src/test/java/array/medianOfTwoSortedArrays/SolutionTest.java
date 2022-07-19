package array.medianOfTwoSortedArrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMedianSortedArrays() {
        Solution solution = new Solution();
        double result = solution.findMedianSortedArrays(new int[]{}, new int[]{1});
        assertEquals(result, 1.0);

        result = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assertEquals(result, 2.0);

        result = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        assertEquals(result, 2.5);

        result = solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0});
        assertEquals(result, 0.0);
    }

}