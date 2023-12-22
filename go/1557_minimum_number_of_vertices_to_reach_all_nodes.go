package main

func findSmallestSetOfVertices(n int, edges [][]int) []int {
	vs := make(map[int]bool)
	for i := 0; i < len(edges); i++ {
		vs[edges[i][1]] = true
	}
	res := make([]int, 0)
	for i := 0; i < n; i++ {
		if !vs[i] {
			res = append(res, i)
		}
	}
	return res
}
