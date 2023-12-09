package main

import "strconv"

//https://www.youtube.com/watch?v=eDtMmysldaw
func splitString1(s string) bool {

	var dfs func(ind, prev int) bool
	dfs = func(ind, prev int) bool {
		if ind == len(s) {
			return true
		}
		for j := ind; j < len(s); j++ {
			val, _ := strconv.Atoi(s[ind : j+1])
			if val+1 == prev && dfs(j+1, val) {
				return true
			}
		}
		return false
	}

	for i := 0; i < len(s)-1; i++ {
		val, _ := strconv.Atoi(s[:i+1])
		if dfs(i+1, val) {
			return true
		}
	}
	return false
}
