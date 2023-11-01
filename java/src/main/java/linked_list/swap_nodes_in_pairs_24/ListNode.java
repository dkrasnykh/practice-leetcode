package linked_list.swap_nodes_in_pairs_24;

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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            ListNode pair = cur.next;
            ListNode nxt = pair.next;
            prev.next = pair;
            pair.next = cur;
            cur.next = nxt;
            prev = cur;
            cur = nxt;
        }
        return dummy.next;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        //ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //node4.next = node5;
        Solution s = new Solution();
        s.print(s.swapPairs(node1));
    }
}