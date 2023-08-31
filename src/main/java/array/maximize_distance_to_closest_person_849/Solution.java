package array.maximize_distance_to_closest_person_849;

public class Solution {

    public int distance(int i, int d, int size){
        if (i == 0) {
            return d;
        } else if (i + d == size) {
            return size - i;
        } else {
            return (d + 1) / 2;
        }
    }
    public int maxDistToClosest(int[] seats) {
        int i = 0, d = 0;
        while (i < seats.length) {
            int l = i;
            while (i < seats.length && seats[i] == 0) {
                i += 1;
            }
            d = Math.max(d, distance(l, i - l, seats.length));
            i += 1;
        }
        return d;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(s.maxDistToClosest(new int[]{1,0,0,0}));
        System.out.println(s.maxDistToClosest(new int[]{0,0,0,1}));
        //[0,1,0,0,0,0]
        System.out.println(s.maxDistToClosest(new int[]{0,1,0,0,0,0}));
    }
}
