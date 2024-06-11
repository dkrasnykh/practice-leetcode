package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	root := &ListNode{Next: head}
	l, r := root, root
	for n > 0 {
		r = r.Next
		n -= 1
	}

	for r.Next != nil {
		r = r.Next
		l = l.Next
	}
	l.Next = l.Next.Next
	return root.Next
}

/*
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	p := 0
	root := &ListNode{Next: head}
	prev, curr := root, head
	for curr.Next != nil {
		curr = curr.Next
		p += 1
		if p >= n {
			prev = prev.Next
		}
	}
	nxt := prev.Next
	prev.Next = nxt.Next
	return root.Next
}
*/
