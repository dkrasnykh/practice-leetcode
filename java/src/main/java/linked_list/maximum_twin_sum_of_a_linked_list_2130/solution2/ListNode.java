package linked_list.maximum_twin_sum_of_a_linked_list_2130.solution2;

//https://www.youtube.com/watch?v=doj95MelfSA
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        int res = 0;
        while (slow != null) {
            res = Math.max(res, prev.val + slow.val);
            prev = prev.next;
            slow = slow.next;
        }
        return res;
    }
}
