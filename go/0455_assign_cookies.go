package main

import "sort"

func findContentChildren(g []int, s []int) int {
	sort.Slice(g, func(i, j int) bool {
		return g[i] < g[j]
	})
	sort.Slice(s, func(i, j int) bool {
		return s[i] < s[j]
	})
	i := 0
	for j := 0; j < len(s); j++ {
		if i < len(g) && g[i] <= s[j] {
			i++
		}
	}
	return i
}
