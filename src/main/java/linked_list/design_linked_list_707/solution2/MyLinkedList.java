package linked_list.design_linked_list_707.solution2;

//https://www.youtube.com/watch?v=Wf4QhpdVFQo
class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class MyLinkedList {
    ListNode left, right;

    public MyLinkedList() {
        left = new ListNode(0);
        right = new ListNode(0);
        left.next = right;
        right.prev = left;
    }

    public int get(int index) {
        ListNode cur = left.next;
        while (cur != null && index > 0) {
            cur = cur.next;
            index -= 1;
        }
        if(cur != null && cur != right && index == 0){
            return cur.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(0), next = left.next, prev = left;
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(0), next = right, prev = right.prev;
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public void addAtIndex(int index, int val) {
        ListNode cur = left.next;
        while(cur!=null && index > 0){
            cur = cur.next;
            index -= 1;
        }
        if(cur != null && index == 0){
            ListNode node = new ListNode(val), next = cur, prev = cur.prev;
            prev.next = node;
            next.prev = node;
            node.next = next;
            node.prev = prev;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode cur = left.next;
        while(cur != null && index > 0){
            cur = cur.next;
            index -= 1;
        }
        if(cur != null && cur != right && index == 0){
            ListNode next = cur.next, prev = cur.prev;
            next.prev = prev;
            prev.next = next;
        }
    }
}
