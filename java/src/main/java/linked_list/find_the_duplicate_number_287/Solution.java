package linked_list.find_the_duplicate_number_287;

//https://www.youtube.com/watch?v=wjYnzkAhcNk
public class Solution {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }

    public static void main(String[] args) {
    }
}
