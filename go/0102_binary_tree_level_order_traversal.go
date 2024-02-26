package main

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	result := [][]int{}
	q := []*TreeNode{}
	q = append(q, root)
	for len(q) > 0 {
		size := len(q)
		tmp := make([]int, size)
		for i := 0; i < size; i++ {
			node := q[0]
			tmp[i] = node.Val
			q = q[1:]
			if node.Left != nil {
				q = append(q, node.Left)
			}
			if node.Right != nil {
				q = append(q, node.Right)
			}
		}
		result = append(result, tmp)
	}
	return result
}
