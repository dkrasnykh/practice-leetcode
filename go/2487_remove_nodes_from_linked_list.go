package main

type ListNode struct {
	Val  int
	Next *ListNode
}

/*
func removeNodes(head *ListNode) *ListNode {
	dummy := &ListNode{Val: 0, Next: head}
	stack := []*ListNode{dummy}
	curr := head
	for curr != nil {
		for len(stack) > 1 && stack[len(stack)-1].Val < curr.Val {
			prev := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			prev.Next = nil
			stack[len(stack)-1].Next = curr
		}
		stack = append(stack, curr)
		curr = curr.Next
	}
	return dummy.Next
}
*/

func removeNodes(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head
	//разворачиваем список
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	//удаляем узлы
	curr = prev
	dummy := &ListNode{Val: 0, Next: curr}
	prev = dummy
	maxValue := 0
	for curr != nil {
		if curr.Val < maxValue {
			prev.Next = curr.Next
		} else {
			prev = curr
		}
		maxValue = max(maxValue, curr.Val)
		curr = curr.Next
	}
	//разворачивам список обратно
	curr, prev = dummy.Next, nil
	dummy.Next = nil
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}

	return prev
}

/*
func main() {
	//[5,2,13,3,8]

	node8 := &ListNode{Val: 8}
	node3 := &ListNode{Val: 3, Next: node8}
	node13 := &ListNode{Val: 13, Next: node3}
	node2 := &ListNode{Val: 2, Next: node13}
	root := &ListNode{Val: 5, Next: node2}

	removeNodes(root)
}
*/
