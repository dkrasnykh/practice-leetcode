package arrays_hashing.maximize_distance_to_closest_person_849;

public class Solution1 {
    public int maxDistToClosest(int[] seats) {
        int prev = -1;
        int max = 0;
        for(int i = 0; i < seats.length; ++i){
            if(seats[i] == 1){
                if(prev == -1){
                    max = Math.max(max, i);
                } else {
                    max = Math.max(max, (i - prev)/2);
                }
                prev = i;
            }
        }
        max = Math.max(max, seats.length - 1 - prev);
        return max;
    }
}
