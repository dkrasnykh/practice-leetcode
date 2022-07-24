package mergeSort.sortList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given the head of a linked list, return the list after sorting it in ascending order.
 */
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

    public static int[] getArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        result.add(head.val);
        ListNode next = head.next;
        while (next != null) {
            result.add(next.val);
            next = next.next;
        }
        int[] b = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            b[i] = result.get(i);
        }
        return b;
    }

    public static ListNode getHead(int[] a) {
        //переписать - должно быть с конца
        ListNode head = new ListNode(a[0]);
        ListNode current = head;
        for (int i = 1; i < a.length; i++) {
            ListNode newNode = new ListNode(a[i]);
            current.next = newNode;
            current = newNode;
        }
        return head;
    }
    public int[] merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = a[p + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = a[q + 1 + i];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] < R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
        return a;
    }

    public int[] mergeSort(int[] a, int p, int r) {
        if(p<r){
            int q = (p+r)/2;
            mergeSort(a, p, q);
            mergeSort(a, q+1, r);
            merge(a, p, q, r);
        }
        return a;
    }

    public ListNode sortList(ListNode head) {
        if (head == null){
            return null;
        }
        int[] a = getArray(head);
        mergeSort(a, 0, a.length-1);
        return getHead(a);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //4 2 1 3
        //-1 5, 3, 4, 0
        //[]
        ListNode listNode5 = new ListNode(0);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(5, listNode3);
        ListNode head = new ListNode(-1, listNode2);
        solution.sortList(head);
    }
}