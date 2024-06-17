package main

func splitListToParts(head *ListNode, k int) []*ListNode {
	res := make([]*ListNode, k)

	lenght := 0
	curr := head
	for curr != nil {
		lenght += 1
		curr = curr.Next
	}

	seq_len := lenght / k
	seq_add := lenght % k

	curr = head
	for i := 0; i < k; i++ {
		if curr == nil {
			break
		}

		partHead := curr
		partCurr := curr

		add := 0
		if seq_add > 0 {
			add = 1
			seq_add -= 1
		}

		for j := 0; j < seq_len+add-1; j++ {
			partCurr = partCurr.Next
		}

		res[i] = partHead
		nxt := partCurr.Next
		partCurr.Next = nil
		curr = nxt
	}
	return res
}
