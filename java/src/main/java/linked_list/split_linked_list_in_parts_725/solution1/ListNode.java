package linked_list.split_linked_list_in_parts_725.solution1;

//https://www.youtube.com/watch?v=-OTlqdrxrVI
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] answer = new ListNode[k];
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length += 1;
        }
        int base_len = length / k, remainder = length % k, i1 = 0;
        curr = head;
        for(int i = 0; i < k; ++i){
            answer[i1] = curr;
            i1 += 1;
            for(int j = 0; j < (base_len - 1 + (remainder > 0 ? 1 : 0)); ++j){
                if(curr == null) break;
                curr = curr.next;
            }
            remainder -= (remainder > 0 ? 1 : 0);
            if(curr != null){
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }
        return answer;
    }
}
