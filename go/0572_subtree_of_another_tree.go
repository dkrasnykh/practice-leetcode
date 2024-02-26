package main

func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
	if root == nil {
		return true
	}
	return isSameTree(root, subRoot) || isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot)
}
