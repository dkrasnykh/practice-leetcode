package main

import (
	"strconv"
)

func tree2str(root *TreeNode) string {
	res := make([]byte, 0)

	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		res = append(res, strconv.Itoa(node.Val)...)
		if node.Left != nil {
			res = append(res, '(')
			dfs(node.Left)
			res = append(res, ')')
		}
		if node.Left == nil && node.Right != nil {
			res = append(res, "()"...)
		}
		if node.Right != nil {
			res = append(res, '(')
			dfs(node.Right)
			res = append(res, ')')
		}
	}
	dfs(root)

	return string(res)
}
