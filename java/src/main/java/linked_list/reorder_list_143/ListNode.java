package linked_list.reorder_list_143;

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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        ListNode left = head, right = prev;
        while (right != null) {
            ListNode nxtLeft = left.next;
            ListNode nxtRight = right.next;
            left.next = right;
            left.next.next = nxtLeft;
            left = nxtLeft;
            right = nxtRight;
        }
        if(left != null){
            left.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        /*
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        */
        Solution s = new Solution();
        s.reorderList(node1);
    }
}
