package main

func mergeInBetween(list1 *ListNode, a int, b int, list2 *ListNode) *ListNode {
	var a_1_node, b_node *ListNode
	i := 0
	curr := list1
	for curr != nil {
		if i == a-1 {
			a_1_node = curr
		}
		if i == b {
			b_node = curr
		}
		curr = curr.Next
		i += 1
	}
	tail2 := list2
	for tail2.Next != nil {
		tail2 = tail2.Next
	}
	a_1_node.Next = list2
	tail2.Next = b_node.Next
	return list1
}
