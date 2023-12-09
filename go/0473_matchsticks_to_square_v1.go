package main

import "sort"

//https://www.youtube.com/watch?v=hUe0cUKV-YY
func makesquare1(matchsticks []int) bool {
	total := 0
	for i := 0; i < len(matchsticks); i++ {
		total += matchsticks[i]
	}
	if total%4 != 0 {
		return false
	}
	sort.Slice(matchsticks, func(i, j int) bool {
		return matchsticks[i] > matchsticks[j]
	})
	sides := [4]int{}
	length := total / 4
	var backtrack func(i int) bool
	backtrack = func(i int) bool {
		if i == len(matchsticks) {
			return true
		}
		for j := 0; j < 4; j++ {
			if sides[j]+matchsticks[i] <= length {
				sides[j] += matchsticks[i]
				if backtrack(i + 1) {
					return true
				}
				sides[j] -= matchsticks[i]
			}
		}
		return false
	}
	return backtrack(0)
}
