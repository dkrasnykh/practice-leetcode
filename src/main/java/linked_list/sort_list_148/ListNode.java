package linked_list.sort_list_148;

//TL
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    private ListNode merge(ListNode node, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        ListNode tmp = new ListNode(0, node);
        ListNode prev = tmp;
        ListNode curr = node;
        for(int i = 0; i < p; ++i){
            ListNode nxt = curr.next;
            prev = curr;
            curr = nxt;
        }
        ListNode left = prev;
        ListNode pNode = curr;

        for(int i = 0; i < n1; ++i){
            ListNode nxt = curr.next;
            prev = curr;
            curr = nxt;
        }

        ListNode qNode = prev;
        ListNode q1Node = curr;

        for(int i= 0; i < n2; ++i){
            ListNode nxt = curr.next;
            prev = curr;
            curr = nxt;
        }
        ListNode rNode = prev;
        ListNode right = curr;

        qNode.next=null;
        rNode.next=null;

        curr = left;
        while (pNode != null && q1Node != null) {
            if (pNode.val <= q1Node.val) {
                curr.next = pNode;
                pNode = pNode.next;
            } else {
                curr.next = q1Node;
                q1Node = q1Node.next;
            }
            curr = curr.next;
        }
        if (pNode != null) {
            curr.next = pNode;
        }
        if (q1Node != null) {
            curr.next = q1Node;
        }

        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = right;
        return tmp.next;
    }

    private ListNode mergeSort(ListNode head, int p, int r){
        if(p < r){
            int q = (p + r)/2;
            head = mergeSort(head, p, q);
            head = mergeSort(head, q + 1, r);
            head = merge(head, p, q, r);
        }
        return head;
    }

    private int lenght(ListNode curr){
        int l = 0;
        while(curr != null){
            curr = curr.next;
            l += 1;
        }
        return l;
    }
    public ListNode sortList(ListNode head) {
        int l = lenght(head);
        return mergeSort(head, 0, l-1);
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        //1 2 4 5 6
        /*
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution s = new Solution();
        s.print(s.sortList(node1));
        */

        ListNode node0 = new ListNode(10);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(10);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Solution s = new Solution();
        s.print(s.sortList(node0));
    }
}
