package main

func pairSum(head *ListNode) int {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	var prev *ListNode
	curr := slow
	for curr != nil {
		nxt := curr.Next
		curr.Next = prev
		prev = curr
		curr = nxt
	}
	ans := 0
	l1, l2 := head, prev
	for l2 != nil {
		ans = max(ans, l1.Val+l2.Val)
		l1 = l1.Next
		l2 = l2.Next
	}
	return ans
}
