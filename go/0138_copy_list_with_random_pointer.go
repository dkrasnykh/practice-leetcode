package main

type Node2 struct {
	Val    int
	Next   *Node2
	Random *Node2
}

func copyRandomList(head *Node2) *Node2 {
	oldToNew := make(map[*Node2]*Node2)
	curr := head

	rootNew := &Node2{}
	prevNew := rootNew
	var currNew *Node2

	for curr != nil {
		newNode := &Node2{Val: curr.Val}
		oldToNew[curr] = newNode
		prevNew.Next = newNode
		prevNew = newNode

		curr = curr.Next
	}

	curr = head
	currNew = rootNew.Next

	for curr != nil {
		currNew.Random = oldToNew[curr.Random]

		curr = curr.Next
		currNew = currNew.Next
	}
	return rootNew.Next
}
