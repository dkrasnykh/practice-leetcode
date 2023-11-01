package two_pointers.trapping_rain_water_42;

//https://www.youtube.com/watch?v=ZI2z5pq0TqA
public class Solution1 {
    public int trap(int[] height) {
        //res(i) = min(min_left, min_right) - height[i]
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while(l < r){
            if(leftMax < rightMax){
                l += 1;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r -= 1;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
