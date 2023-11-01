package linked_list.remove_duplicates_from_sorted_list_83.solution1;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
