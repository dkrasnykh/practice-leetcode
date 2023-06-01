package linked_list.sort_list_148.solution2;

//https://www.youtube.com/watch?v=TGveA1oFhrc
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }
}