package main

func deleteNode(root *TreeNode, key int) *TreeNode {
	if root == nil {
		return nil
	}
	if root.Val == key {
		if root.Left == nil && root.Right == nil {
			return nil
		}
		var newRoot *TreeNode
		if root.Left != nil {
			if root.Left.Right == nil {
				newRoot = root.Left
				newRoot.Right = root.Right
			} else {
				curr, prev := root.Left.Right, root.Left
				for curr.Right != nil {
					prev = curr
					curr = curr.Right
				}
				prev.Right = curr.Left
				newRoot = curr
				newRoot.Left = root.Left
				newRoot.Right = root.Right
			}
		} else {
			if root.Right.Left == nil {
				newRoot = root.Right
				newRoot.Left = root.Left
			} else {
				curr, prev := root.Right.Left, root.Right
				for curr.Left != nil {
					prev = curr
					curr = curr.Left
				}
				prev.Left = curr.Right
				newRoot = curr
				newRoot.Right = root.Right
				newRoot.Left = root.Left
			}
		}
		root.Left, root.Right = nil, nil
		return newRoot
	}
	if root.Val < key {
		root.Right = deleteNode(root.Right, key)
	}
	if key < root.Val {
		root.Left = deleteNode(root.Left, key)
	}
	return root
}
