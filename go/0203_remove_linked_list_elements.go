package main

func removeElements(head *ListNode, val int) *ListNode {
	root := &ListNode{Next: head}
	prev, curr := root, head
	for curr != nil {
		if curr.Val == val {
			prev.Next = curr.Next
		} else {
			prev = curr
		}
		curr = curr.Next
	}
	return root.Next
}
