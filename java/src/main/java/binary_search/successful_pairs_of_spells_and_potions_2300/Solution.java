package binary_search.successful_pairs_of_spells_and_potions_2300;

import java.util.Arrays;

public class Solution {
    private int binsearch(int[] potions, long spell, long success){
        int l = 0, r = potions.length - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            if(spell * potions[m] >= success){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; ++i){
            result[i] = potions.length - binsearch(potions, spells[i], success);
        }
        return result;
    }
}
