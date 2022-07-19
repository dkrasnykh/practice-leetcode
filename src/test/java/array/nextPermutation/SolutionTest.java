package array.nextPermutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void nextPermutation() {
        //input  {0, 1, 2, 5, 3, 3, 0}
        //result {0, 1, 3, 0, 2, 3, 5}

        //input  [4,0,5,29,14,16,9,2,12,14,7,27,15,4,8,11,2,18,29,3,16,8,10,22,11,10,15,1,1,0,28,5,0,26,4,6,12,5,8,16,12,8,14,27,12,14,0,6,2,29,9,10,8,11,3]
        //result [4,0,5,29,14,16,9,2,12,14,7,27,15,4,8,11,2,18,29,3,16,8,10,22,11,10,15,1,1,0,28,5,0,26,4,6,12,5,8,16,12,8,14,27,12,14,0,6,2,29,9,10,11,3,8]
    }
}