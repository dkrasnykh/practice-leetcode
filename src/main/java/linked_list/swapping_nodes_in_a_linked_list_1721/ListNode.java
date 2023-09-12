package linked_list.swapping_nodes_in_a_linked_list_1721;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode root = new ListNode(0, head);
        int n = k + 1; //with the root node
        ListNode l = root, r = root;
        while(n > 2){
            r = r.next;
            n -= 1;
        }
        ListNode prev1 = r;
        while(n > 0){
            r = r.next;
            n -= 1;
        }
        while(r != null){
            r = r.next;
            l = l.next;
        }
        ListNode prev2 = l;
        ListNode nextnext1 = prev1.next.next;
        ListNode nextnext2 = prev2.next.next;
        if(prev1.next == prev2){
            prev1.next = prev2.next;
            prev1.next.next = prev2;
            prev2.next = nextnext2;
        } else if (prev2.next == prev1){
            prev2.next = prev1.next;
            prev2.next.next = prev1;
            prev1.next = nextnext1;
        } else {
            ListNode next1 = prev1.next;
            prev1.next = prev2.next;
            prev2.next.next = nextnext1;
            prev2.next = next1;
            prev2.next.next = nextnext2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        //[7,9,6,6,7,8,3,0,9,5]
        /*
        ListNode node10 = new ListNode(5);
        ListNode node9 = new ListNode(9, node10);
        ListNode node8 = new ListNode(0, node9);
        ListNode node7 = new ListNode(3, node8);
        ListNode node6 = new ListNode(8, node7);
        ListNode node5 = new ListNode(7, node6);
        ListNode node4 = new ListNode(6, node5);
        ListNode node3 = new ListNode(6, node4);
        ListNode node2 = new ListNode(9, node3);
        ListNode node1 = new ListNode(7, node2);
        Solution s = new Solution();
        ListNode result = s.swapNodes(node1, 7);

        test case 2
        ListNode node1 = new ListNode(7);
        Solution s = new Solution();
        ListNode result = s.swapNodes(node1, 1);


        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        Solution s = new Solution();
        ListNode result = s.swapNodes(node1, 2);

         */
        ListNode node1 = new ListNode(7);
        Solution s = new Solution();
        ListNode result = s.swapNodes(node1, 1);
        int test = 5;
    }
}