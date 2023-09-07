package binary_search.capacity_to_ship_packages_within_d_days_1011;

public class Solution {
    public boolean check(int[] weights, int days, int capacity){
        int i = 0;
        for(int d = 0; d < days; ++d){
            int shipCapacity = capacity;
            while(i < weights.length && shipCapacity - weights[i] >= 0){
                shipCapacity -= weights[i];
                i += 1;
            }
        }
        return i == weights.length;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = weights[weights.length - 1], r = weights.length * 500;
        while(l <= r){
            int m = l + (r - l)/2;
            if(check(weights, days, m)){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
