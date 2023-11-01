package two_pointers.boats_to_save_people_881;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int res = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l += 1;
                r -= 1;
            } else {
                r -= 1;
            }
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(s.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(s.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
