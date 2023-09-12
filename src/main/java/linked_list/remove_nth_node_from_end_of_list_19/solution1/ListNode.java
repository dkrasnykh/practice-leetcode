package linked_list.remove_nth_node_from_end_of_list_19.solution1;

//https://www.youtube.com/watch?v=XVuQxVej6y8
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0, head);
        ListNode left = root, right = head;
        while(n > 0){
            right = right.next;
            n -= 1;
        }
        while(right != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return root.next;
    }
}
