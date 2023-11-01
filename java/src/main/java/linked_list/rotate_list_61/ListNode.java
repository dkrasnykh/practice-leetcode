package linked_list.rotate_list_61;

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
    private int lenght(ListNode head) {
        int l = 0;
        while (head != null) {
            head = head.next;
            l += 1;
        }
        return l;
    }

    private ListNode get(ListNode head, int p) {
        for (int i = 0; i < p; ++i) {
            head = head.next;
        }
        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int l = lenght(head);
        if(k % l == 0) return head;
        int p = l - k % l;
        ListNode node = get(head, p - 1);
        ListNode tail = get(head, l - 1);
        ListNode newHead = node.next;
        node.next = null;
        tail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        /*
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
        s.rotateRight(node1, 2);
        */
        ListNode node1 = new ListNode(1);

        Solution s = new Solution();
        s.rotateRight(node1, 0);
    }
}
