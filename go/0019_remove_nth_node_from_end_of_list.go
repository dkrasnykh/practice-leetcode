package main

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
