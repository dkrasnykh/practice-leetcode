package main

func reorderList(head *ListNode) {
	fast, slow := head, head

	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}

	var prev *ListNode
	curr := slow.Next
	slow.Next = nil

	for curr != nil {
		nxt := curr.Next
		curr.Next = prev
		prev = curr
		curr = nxt
	}

	l1, l2 := head, prev

	for l1 != nil && l2 != nil {
		nxt := l1.Next
		l1.Next = l2
		l2 = l2.Next
		l1.Next.Next = nxt
		l1 = l1.Next.Next
	}
}
