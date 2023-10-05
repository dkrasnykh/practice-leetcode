package arrays_hashing.find_the_prefix_common_array_of_two_arrays_2657;

import java.util.*;

public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] C = new int[A.length];
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> counted = new HashSet<>();
        int prev = 0;
        for(int i = 0; i < A.length; ++i){
            a.add(A[i]);
            b.add(B[i]);
            C[i] += prev;
            if(!counted.contains(A[i]) && b.contains(A[i])){
                C[i] += 1;
                counted.add(A[i]);
            }
            if(!counted.contains(B[i]) && a.contains(B[i])){
                C[i] += 1;
                counted.add(B[i]);
            }
            prev = C[i];
        }
        return C;
    }
}
