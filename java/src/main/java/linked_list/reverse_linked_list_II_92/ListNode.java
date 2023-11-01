package linked_list.reverse_linked_list_II_92;

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
    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = new ListNode(0, head);
        ListNode dummy = leftNode;
        ListNode rightNode;
        int i = 2;
        ListNode prev = head;
        ListNode curr = head.next;
        for (; i <= left; ++i) {
            ListNode tmp = curr.next;
            leftNode = prev;
            prev = curr;
            curr = tmp;
        }
        i = left;
        ListNode subTail = prev;
        for (; i < right; ++i) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        ListNode subHead = prev;
        rightNode = curr;
        leftNode.next = subHead;
        subTail.next = rightNode;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution s = new Solution();
        s.print(s.reverseBetween(node1, 2, 5));
    }
}
