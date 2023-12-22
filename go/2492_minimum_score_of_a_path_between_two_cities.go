package main

func minScore(n int, roads [][]int) int {
	adj := make([][][2]int, n+1)
	for _, v := range roads {
		adj[v[0]] = append(adj[v[0]], [...]int{v[1], v[2]})
		adj[v[1]] = append(adj[v[1]], [...]int{v[0], v[2]})
	}
	used := make([]bool, n+1)
	res := 1000000
	var dfs func(v int)
	dfs = func(v int) {
		used[v] = true
		for _, e := range adj[v] {
			u := e[0]
			w := e[1]
			res = min(res, w)
			if !used[u] {
				dfs(u)
			}
		}
	}
	dfs(1)
	return res
}
