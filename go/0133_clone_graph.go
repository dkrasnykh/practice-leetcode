package main

type Node struct {
	Val       int
	Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}
	m := make(map[int]*Node)
	return clone(node, m)
}

func clone(node *Node, m map[int]*Node) *Node {
	if _, ok := m[node.Val]; ok {
		return m[node.Val]
	}
	copy := &Node{Val: node.Val, Neighbors: make([]*Node, len(node.Neighbors))}
	m[node.Val] = copy
	for i := 0; i < len(node.Neighbors); i++ {
		copy.Neighbors[i] = clone(node.Neighbors[i], m)
	}
	return copy
}

func main() {
	node := &Node{Val: 1}
	cloneGraph(node)
}
