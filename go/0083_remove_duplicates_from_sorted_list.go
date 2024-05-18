package main

func deleteDuplicates(head *ListNode) *ListNode {
	root := &ListNode{Val: 105, Next: head}
	prev, curr := root, head
	for curr != nil {
		if curr.Val == prev.Val {
			prev.Next = curr.Next
		} else {
			prev = curr
		}
		curr = curr.Next
	}
	return root.Next
}
