package linked_list.add_two_numbers_2.solution1;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode prev = root;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode curr = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            prev.next = curr;
            prev = curr;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ListNode curr = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            prev.next = curr;
            prev = curr;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode curr = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            prev.next = curr;
            prev = curr;
            l2 = l2.next;
        }
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        return root.next;
    }
}
