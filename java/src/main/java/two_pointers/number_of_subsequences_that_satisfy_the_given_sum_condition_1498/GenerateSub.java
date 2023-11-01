package two_pointers.number_of_subsequences_that_satisfy_the_given_sum_condition_1498;

import java.util.ArrayList;
import java.util.List;

//for test cases
public class GenerateSub {
    public static List<Integer> subset = new ArrayList<>();
    public static int cnt = 0;

    public static void generateSunset(int k, int n, int[] nums){
        if(k==n+1){
            cnt++;
            for(int i = 0; i<subset.size(); ++i){
                System.out.print(subset.get(i) + " ");
            }
            System.out.println();
        } else {
            subset.add(nums[k]);
            generateSunset(k+1, n, nums);
            Integer o = subset.get(subset.size()-1);
            subset.remove(o);
            generateSunset(k+1, n, nums);
        }
    }

    public static void main(String[] args) {
        //i = 0
        //n = nums.lenght()-1
        int[] nums = {1,2,3,4,5,6};
        generateSunset(0, nums.length-1, nums);
        System.out.println("-----------------------------");
        System.out.println(cnt);
    }
}
