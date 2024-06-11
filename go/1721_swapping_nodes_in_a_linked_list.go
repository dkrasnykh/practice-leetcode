package main

func swapNodes(head *ListNode, k int) *ListNode {
	length := 0
	curr := head
	for curr != nil {
		curr = curr.Next
		length += 1
	}

	if length%2 == 1 && k == length/2+1 {
		return head
	}

	a, b := min(k, length-k+1), max(k, length-k+1)

	root := &ListNode{Next: head}
	prev_a, prev_b := root, root

	ind := 1
	curr = head
	for curr.Next != nil {
		if ind == a-1 {
			prev_a = curr
		}
		if ind == b-1 {
			prev_b = curr
		}

		curr = curr.Next
		ind += 1
	}

	if a == b-1 {
		a_node := prev_a.Next
		b_node := prev_a.Next.Next
		nxt := b_node.Next
		prev_a.Next = b_node
		b_node.Next = a_node
		a_node.Next = nxt
		return root.Next
	}

	a_node := prev_a.Next
	b_node := prev_b.Next
	nxt_a := a_node.Next
	nxt_b := b_node.Next

	prev_a.Next = b_node
	b_node.Next = nxt_a

	prev_b.Next = a_node
	a_node.Next = nxt_b

	return root.Next
}
