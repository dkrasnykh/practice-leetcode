package linked_list.partition_list_86;

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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0, head);
        ListNode less = dummy;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                ListNode currNxt = curr.next;
                prev.next = currNxt;
                ListNode lessNxt = less.next;
                less.next = curr;
                curr.next = lessNxt;
                if(less==prev){
                    less = curr;
                    prev = curr;
                } else {
                    less = curr;
                }

                curr = currNxt;
            } else {
                ListNode tmp = curr.next;
                prev = curr;
                curr = tmp;
            }
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
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Solution s = new Solution();
        s.print(s.partition(node1, 3));


        /*
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;

        Solution s = new Solution();
        s.print(s.partition(node1, 2));
        */
    }
}
