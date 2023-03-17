package array.majority_element_169;

//https://www.youtube.com/watch?v=7pnhv842keE
public class Solution2 {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (Integer n : nums) {
            if (count == 0) {
                res = n;
            }
            count += (n == res ? 1 : -1);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
