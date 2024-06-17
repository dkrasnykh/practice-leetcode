package main

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	if left == right {
		return head
	}
	root := &ListNode{Next: head}
	curr := head
	p := 1
	prev_left, after_right := root, root
	var left_node, right_node *ListNode

	for curr != nil {
		if p == left-1 {
			prev_left = curr
		}
		if p == left {
			left_node = curr
		}
		if p == right {
			right_node = curr
			after_right = curr.Next
			break
		}

		p += 1
		curr = curr.Next
	}

	var prev *ListNode
	curr = left_node

	for curr != after_right {
		nxt := curr.Next
		curr.Next = prev

		prev = curr
		curr = nxt
	}

	prev_left.Next = right_node
	left_node.Next = after_right

	return root.Next
}
