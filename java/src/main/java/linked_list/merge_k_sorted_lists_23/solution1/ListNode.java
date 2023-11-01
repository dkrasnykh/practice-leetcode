package linked_list.merge_k_sorted_lists_23.solution1;

import java.util.ArrayDeque;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    private ListNode merge(ListNode list1, ListNode list2){
        ListNode root = new ListNode();
        ListNode curr = root;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return root.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ArrayDeque<ListNode> queue = new ArrayDeque<>();
        for(int i = 0; i < lists.length; ++i){
            if(lists[i] != null){
                queue.addLast(lists[i]);
            }
        }
        while(queue.size() > 1){
            ListNode list1 = queue.pollFirst();
            ListNode list2 = queue.pollFirst();
            queue.addLast(merge(list1, list2));
        }
        return queue.size() == 0 ? null : queue.pollFirst();
    }
}