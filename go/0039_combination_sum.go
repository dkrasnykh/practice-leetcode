package main

func combinationSum(candidates []int, target int) [][]int {
	result := make([][]int, 0)
	comb := make([]int, 0)

	sumup := func() int {
		total := 0
		for _, v := range comb {
			total += v
		}
		return total
	}

	var backtrack func(ind int)
	backtrack = func(ind int) {
		total := sumup()
		if total == target {
			tmp := make([]int, len(comb))
			copy(tmp, comb)
			result = append(result, tmp)
			return
		}
		//if total > target || ind >= len(candidates) {
		if total > target {
			return
		}
		/*
			comb = append(comb, candidates[ind])
			backtrack(ind)
			comb = comb[:len(comb)-1]
			backtrack(ind + 1)
		*/
		for i := ind; i < len(candidates); i++ {
			comb = append(comb, candidates[i])
			backtrack(i)
			comb = comb[:len(comb)-1]
		}
	}
	backtrack(0)
	return result
}
