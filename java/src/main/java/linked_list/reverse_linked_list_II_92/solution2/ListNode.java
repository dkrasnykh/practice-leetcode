package linked_list.reverse_linked_list_II_92.solution2;

//https://www.youtube.com/watch?v=RF_M9tX4Eag
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftPrev = dummy;
        ListNode cur = head;
        for(int i = 0; i < left - 1; ++i){
            leftPrev = cur;
            cur = cur.next;
        }
        ListNode prev = null;
        for(int i = 0; i < right - left + 1; ++i){
            ListNode tmpNxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmpNxt;
        }
        leftPrev.next.next = cur;
        leftPrev.next = prev;
        return dummy.next;
    }

}