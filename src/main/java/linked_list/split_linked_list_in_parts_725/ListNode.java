package linked_list.split_linked_list_in_parts_725;

import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] answer = new ListNode[k];
        ListNode curr = head;
        List<ListNode> list = new ArrayList<>();
        while(curr != null){
            list.add(curr);
            curr = curr.next;
        }
        int i = 0, j = 0;
        while(i < list.size()){
            answer[j] = list.get(i);
            if(i > 0){
                list.get(i - 1).next = null;
            }
            int length = (list.size()/k == 0 ? 1 : list.size()/k + (j < list.size()% k ? 1 : 0));
            i += length;
            j += 1;
        }
        return answer;
    }
}