package main

func traverse(node *TreeNode, leafs *[]int) {
	if node == nil {
		return
	}
	traverse(node.Left, leafs)
	if node.Right == nil && node.Left == nil {
		*leafs = append(*leafs, node.Val)
	}
	traverse(node.Right, leafs)
}

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
	leafs1 := make([]int, 0)
	leafs2 := make([]int, 0)
	traverse(root1, &leafs1)
	traverse(root2, &leafs2)
	if len(leafs1) != len(leafs2) {
		return false
	}
	for i := 0; i < len(leafs1); i++ {
		if leafs1[i] != leafs2[i] {
			return false
		}
	}
	return true
}
