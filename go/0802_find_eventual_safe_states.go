package main

import (
	"fmt"
	"sort"
)

func eventualSafeNodes(graph [][]int) []int {
	n := len(graph)
	used := make([]bool, n)
	set := make(map[int]bool)
	isSafe := func(v int) bool {
		for _, u := range graph[v] {
			if !set[u] {
				return false
			}
		}
		return true
	}

	var dfs func(v int)
	dfs = func(v int) {
		used[v] = true
		for _, u := range graph[v] {
			if used[u] {
				continue
			}
			dfs(u)
		}
		if isSafe(v) {
			set[v] = true
		}
	}

	for v := 0; v < n; v++ {
		if used[v] {
			continue
		}
		dfs(v)
	}
	fmt.Println(set)
	res := make([]int, 0, len(set))
	for k, _ := range set {
		res = append(res, k)
	}
	sort.Slice(res, func(i, j int) bool {
		return res[i] < res[j]
	})
	return res
}
