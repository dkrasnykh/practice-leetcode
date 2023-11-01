package linked_list.remove_nth_node_from_end_of_list_19;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = head;
        int i = 0;
        while(curr != null){
            if(i - n >= 0){
                prev = prev.next;
            }
            i += 1;
            curr = curr.next;
        }
        prev.next = prev.next.next;
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
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution s = new Solution();
        s.print(s.removeNthFromEnd(node1, 2));
    }
}
