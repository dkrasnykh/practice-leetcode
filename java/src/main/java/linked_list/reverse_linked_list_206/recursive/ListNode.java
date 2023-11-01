package linked_list.reverse_linked_list_206.recursive;

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
    private ListNode recursive(ListNode prev, ListNode curr){
        if(curr == null){
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return recursive(curr, next);
    }
    public ListNode reverseList(ListNode head) {
        return recursive(null, head);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = s.reverseList(node1);
        int test = 5;
    }
}
