package linked_list.reverse_nodes_in_k_group_25;

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
    private ListNode reverse(ListNode prevNode, ListNode tail) {
        ListNode prev = null, head1 = prevNode.next, curr = prevNode.next;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head1.next = curr;
        prevNode.next = prev;
        return head1;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0, head);
        ListNode curr = root;
        ListNode head1 = root;
        while(curr != null){
            boolean ended = false;
            curr = head1;
            for(int i = 0; i < k; ++i){
                if(curr == null){
                    ended = true;
                    break;
                }
                curr = curr.next;
            }
            if(ended || curr == null){
                break;
            }
            head1 = reverse(head1, curr);
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        Solution s = new Solution();
        ListNode reversed = s.reverseKGroup(node1, 2);
        int test = 5;
    }
}
