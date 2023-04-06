package sliding_window.find_k_closest_elements_658;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=o-YDQzHoaKM
public class Solution1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while(l < r){
            int m = (l + r)/2;
            if(x - arr[m] > arr[m + k] - x){
                l = m + 1;
            } else {
                r = m;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i < l + k; ++i) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
