package array.removeElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void removeElement() {
        Solution solution = new Solution();
        assertEquals(solution.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2), 5);
        assertEquals(solution.removeElement(new int[]{3,2,2,3}, 3), 2);
        assertEquals(solution.removeElement(new int[]{2}, 3), 1);
        assertEquals(solution.removeElement(new int[]{}, 0), 0);
        assertEquals(solution.removeElement(new int[]{2, 2, 2}, 2), 0);
    }
}