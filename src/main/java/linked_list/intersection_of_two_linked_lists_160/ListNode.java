package linked_list.intersection_of_two_linked_lists_160;

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
        int lA = 0, lB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            lA += 1;
            currA = currA.next;
        }
        while (currB != null) {
            lB += 1;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        int lenght = lA;
        if (lA > lB) {
            lenght = lB;
            for (int i = 0; i < lA - lB; ++i)
                currA = currA.next;
        } else if (lB > lA){
            lenght = lA;
            for (int i = 0; i < lB - lA; ++i) {
                currB = currB.next;
            }
        }
        for (int i = 0; i < lenght; ++i) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(1);

        node11.next = node12;

        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(1);

        node21.next = node22;
        node22.next = node23;

        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node3.next = node4;
        node4.next = node5;

        node12.next = node3;
        node23.next = node3;

        Solution s = new Solution();
        System.out.println(s.getIntersectionNode(node11, node21).val);
    }
}
