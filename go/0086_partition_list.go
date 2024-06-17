package main

func partition1(head *ListNode, x int) *ListNode {
	root := &ListNode{Next: head}
	l, r, prev := root, head, root

	for r != nil {
		if r.Val < x && l.Next != r {
			r_nxt := r.Next
			curr := r
			prev.Next = r_nxt

			l_nxt := l.Next
			l.Next = curr
			curr.Next = l_nxt
			l = curr

			r = r_nxt
			continue
		}

		if r.Val < x {
			l = l.Next
		}

		prev = r
		r = r.Next
	}
	return root.Next
}
