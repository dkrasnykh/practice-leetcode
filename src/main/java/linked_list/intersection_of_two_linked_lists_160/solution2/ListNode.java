package linked_list.intersection_of_two_linked_lists_160.solution2;

//https://www.youtube.com/watch?v=D0X0BONOQhI
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 != null) ? l1.next : headB;
            l2 = (l2 != null) ? l2.next : headA;
        }
        return l1;
    }

    public static void main(String[] args) {
    }
}
