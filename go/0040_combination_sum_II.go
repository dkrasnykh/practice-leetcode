package main

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	sort.Slice(candidates, func(i, j int) bool {
		return candidates[i] < candidates[j]
	})

	result := make([][]int, 0)
	curr := make([]int, 0)

	var backtrack func(ind, total int)
	backtrack = func(ind, total int) {
		if total == target {
			tmp := make([]int, len(curr))
			copy(tmp, curr)
			result = append(result, tmp)
			return
		}
		if total > target || ind == len(candidates) {
			return
		}
		curr = append(curr, candidates[ind])
		backtrack(ind+1, total+candidates[ind])
		tmp := curr[len(curr)-1]
		curr = curr[:len(curr)-1]
		for ind+1 < len(candidates) && candidates[ind+1] == tmp {
			ind += 1
		}
		backtrack(ind+1, total)
	}
	backtrack(0, 0)
	return result
}
