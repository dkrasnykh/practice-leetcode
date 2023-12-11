package main

func checkIfPrerequisite(numCourses int, prerequisites [][]int, queries [][]int) []bool {
	adj := make([][]int, numCourses)
	for _, v := range prerequisites {
		ai := v[0]
		bi := v[1]
		adj[ai] = append(adj[ai], bi)
	}
	var used []bool
	var dfs func(v, f int) bool
	dfs = func(v, f int) bool {
		used[v] = true
		ans := false
		for _, u := range adj[v] {
			if used[u] {
				continue
			}
			if u == f {
				return true
			}
			ans = ans || dfs(u, f)
		}
		return ans
	}
	res := make([]bool, 0)
	for _, q := range queries {
		ai := q[0]
		bi := q[1]
		used = make([]bool, numCourses)
		res = append(res, dfs(ai, bi))
	}
	return res
}
