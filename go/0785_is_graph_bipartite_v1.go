package main

// https://www.youtube.com/watch?v=mev55LTubBY
func isBipartite1(graph [][]int) bool {
	odd := make([]int, len(graph))
	var bfs func(i int) bool
	bfs = func(i int) bool {
		if odd[i] != 0 {
			return true
		}
		q := []int{i}
		odd[i] = -1
		for len(q) > 0 {
			i = q[0]
			q = q[1:]
			for _, nei := range graph[i] {
				if odd[i] == odd[nei] {
					return false
				} else if odd[nei] == 0 {
					q = append(q, nei)
					odd[nei] = -1 * odd[i]
				}
			}
		}
		return true
	}
	for i := 0; i < len(graph); i++ {
		if !bfs(i) {
			return false
		}
	}
	return true
}
