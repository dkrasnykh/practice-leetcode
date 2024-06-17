package main

func rotateRight(head *ListNode, k int) *ListNode {
	lenght := 0
	curr := head
	for curr != nil {
		curr = curr.Next
		lenght += 1
	}
	if lenght == 0 {
		return head
	}

	k = k % lenght

	if k == 0 {
		return head
	}

	curr = head
	for k > 0 {
		curr = curr.Next
		k -= 1
	}

	prev := head
	for curr.Next != nil {
		curr = curr.Next
		prev = prev.Next
	}

	newHead := prev.Next

	prev.Next = nil
	curr.Next = head

	return newHead
}
