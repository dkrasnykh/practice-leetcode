package linked_list.linked_list_cycle_II_142;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        ListNode slow2 = head;
        while(slow != slow2){
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }
}