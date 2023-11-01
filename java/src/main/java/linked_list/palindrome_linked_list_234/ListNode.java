package linked_list.palindrome_linked_list_234;

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
        int res = 0;
        while (head != null) {
            head = head.next;
            res += 1;
        }
        return res;
    }
    public boolean isPalindrome(ListNode head) {
        int l = lenght(head);

        int m = (l % 2 == 0) ? l / 2-1 : l / 2;
        ListNode prev = null;
        ListNode curr = head;
        int i = 0;
        while (i <= m) {
            i += 1;
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        if (l % 2 != 0) {
            prev = prev.next;
        }
        while (prev != null && curr != null) {
            if (prev.val != curr.val) {
                return false;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
         /*
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node4;
        node4.next = node5;
        */

        //ListNode node1 = new ListNode(1);
        //ListNode node2 = new ListNode(0);
        //ListNode node4 = new ListNode(0);
        //node1.next = node2;
        //node2.next = node4;
        System.out.println(s.isPalindrome(node1));
    }
}
