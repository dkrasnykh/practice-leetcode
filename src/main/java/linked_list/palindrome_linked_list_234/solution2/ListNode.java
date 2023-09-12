package linked_list.palindrome_linked_list_234.solution2;

//https://www.youtube.com/watch?v=yOzXms1J6Nk
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
        int i = 0;
        ListNode prev = null, curr = head;
        while(curr != null){
            if(i == n){
                prev = head;
            } else if (i > n){
                prev = prev.next;
            }
            i += 1;
            curr = curr.next;
        }
        if(prev == null){
            return head.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head5 = new ListNode(5);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        //[1,2,3,4,5]
        ListNode result = s.removeNthFromEnd(head1, 2);
        //System.out.println(s.isPalindrome(head));
    }
}
