package main

func swapPairs(head *ListNode) *ListNode {
	root := &ListNode{Next: head}
	prev, curr := root, head

	for curr != nil && curr.Next != nil {
		node1, node2 := curr, curr.Next
		nxt := node2.Next

		prev.Next = node2
		node2.Next = node1
		node1.Next = nxt

		curr = nxt
		prev = node1
	}
	return root.Next
}
