package main

/*
neetcode.io
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if p.Val > root.Val && q.Val > root.Val {
		return lowestCommonAncestor(root.Right, p, q)
	}

	if p.Val < root.Val && q.Val < root.Val {
		return lowestCommonAncestor(root.Left, p, q)
	}

	return root
}
*/

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var dfs func(node, p, q *TreeNode) *TreeNode
	dfs = func(node, p, q *TreeNode) *TreeNode {
		if node == nil {
			return nil
		}
		if p.Val <= node.Val && q.Val >= node.Val {
			return node
		}
		l := lowestCommonAncestor(node.Left, p, q)
		if l != nil {
			return l
		}
		r := lowestCommonAncestor(node.Right, p, q)
		if r != nil {
			return r
		}
		return nil
	}
	if p.Val < q.Val {
		return dfs(root, p, q)
	} else {
		return dfs(root, q, p)
	}
}
