package linked_list.palindrome_linked_list_234.solution3;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null, next = null;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;

            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if(fast.next == null){
            slow = slow.next;
        } else {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while(slow != null && prev != null){
            if(prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return prev == null && slow == null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //1 2 3 2 1
        ListNode node5 = new ListNode(1);
        //ListNode node4 = new ListNode(2, node5);
        //ListNode node3 = new ListNode(3, node4);
        //ListNode node2 = new ListNode(2, node3);
        ListNode node2 = new ListNode(2, node5);
        ListNode head = new ListNode(1, node2);
        System.out.println(s.isPalindrome(head));

    }
}
