package linked_list.rotate_list_61.solution1;

//https://www.youtube.com/watch?v=UcGtPs2LE_c
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            length += 1;
        }
        k = k % length;
        if(k == 0){
            return head;
        }

        ListNode curr = head;
        for(int i = 0; i < length - k - 1; ++i){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        return newHead;
    }
}
