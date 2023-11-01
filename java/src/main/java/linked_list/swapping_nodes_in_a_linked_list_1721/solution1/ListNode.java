package linked_list.swapping_nodes_in_a_linked_list_1721.solution1;

//https://www.youtube.com/watch?v=4LsrgMyQIjQ
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        for(int i = 0; i < k - 1; ++i){
            curr = curr.next;
        }
        ListNode left = curr, right = head;
        while(curr.next != null){
            curr = curr.next;
            right = right.next;
        }
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        return head;
    }
}