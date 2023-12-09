package main

func minReorder(n int, connections [][]int) int {
	set := make(map[[2]int]bool)
	adj := make([][]int, n)
	for i := 0; i < len(connections); i++ {
		a := connections[i][0]
		b := connections[i][1]
		set[[2]int{a, b}] = true
		if adj[a] == nil {
			adj[a] = make([]int, 0)
		}
		if adj[b] == nil {
			adj[b] = make([]int, 0)
		}
		adj[a] = append(adj[a], b)
		adj[b] = append(adj[b], a)
	}
	used := make([]bool, n)
	ans := 0
	var dfs func(v int)
	dfs = func(v int) {
		used[v] = true
		for _, u := range adj[v] {
			if used[u] {
				continue
			}
			if set[[2]int{v, u}] {
				ans += 1
			}
			dfs(u)
		}
	}
	dfs(0)
	return ans
}
