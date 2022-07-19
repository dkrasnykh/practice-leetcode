package array.searchInRotatedSortedArray;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void search() {
        Solution solution = new Solution();
        assertEquals(4, solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(-1, solution.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}