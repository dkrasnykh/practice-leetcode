package main

func combinationSum1(candidates []int, target int) [][]int {
	result := make([][]int, 0)
	comb := make([]int, 0)

	var dfs func(i int, total int)
	dfs = func(i int, total int) {
		if total == target {
			tmp := make([]int, len(comb))
			copy(tmp, comb)
			result = append(result, tmp)
			return
		}
		if i >= len(candidates) || total > target {
			return
		}
		comb = append(comb, candidates[i])
		dfs(i, total+candidates[i])
		comb = comb[:len(comb)-1]
		dfs(i+1, total)
	}
	dfs(0, 0)
	return result
}
