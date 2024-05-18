package main

func isPalindrome1(head *ListNode) bool {
	fast := head
	slow := head
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}

	var prev *ListNode
	curr := slow
	for curr != nil {
		next := curr.Next
		curr.Next = prev

		prev = curr
		curr = next
	}

	for head != nil && prev != nil {
		if head.Val != prev.Val {
			return false
		}
		head = head.Next
		prev = prev.Next
	}
	return true
}
