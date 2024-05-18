package main

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head
	for curr != nil {
		nxt := curr.Next
		curr.Next = prev
		prev = curr
		curr = nxt
	}
	return prev
}
