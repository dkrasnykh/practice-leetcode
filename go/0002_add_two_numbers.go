package main

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	root := &ListNode{}
	prev := root
	carry := 0
	for l1 != nil && l2 != nil {
		val := l1.Val + l2.Val + carry
		curr := &ListNode{Val: val % 10}
		prev.Next = curr
		prev = curr
		carry = val / 10
		l1 = l1.Next
		l2 = l2.Next
	}

	for l1 != nil {
		val := l1.Val + carry
		curr := &ListNode{Val: val % 10}
		prev.Next = curr
		prev = curr
		carry = val / 10
		l1 = l1.Next
	}

	for l2 != nil {
		val := l2.Val + carry
		curr := &ListNode{Val: val % 10}
		prev.Next = curr
		prev = curr
		carry = val / 10
		l2 = l2.Next
	}

	if carry != 0 {
		prev.Next = &ListNode{Val: carry}
	}
	return root.Next
}
