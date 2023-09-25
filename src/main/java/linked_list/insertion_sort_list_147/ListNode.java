package linked_list.insertion_sort_list_147;

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
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode(-5500);
        ListNode curr2 = head;
        while(curr2 != null){
            ListNode tmp = curr2;
            curr2 = curr2.next;
            tmp.next = null;
            ListNode curr1 = root, prev1 = null;
            while(curr1 != null && curr1.val < tmp.val){
                prev1 = curr1;
                curr1 = curr1.next;
            }
            prev1.next = tmp;
            tmp.next = curr1;
        }
        return root.next;
    }
}