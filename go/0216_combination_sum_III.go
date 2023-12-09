package main

func combinationSum3(k int, n int) [][]int {
	result := make([][]int, 0)
	curr := make([]int, 0)

	var backtrack func(ind, sum int)
	backtrack = func(ind, sum int) {
		if len(curr) == k && sum == n {
			result = append(result, append([]int{}, curr...))
			return
		}
		for i := ind; i <= 9; i++ {
			if len(curr) < k && sum+i <= n {
				curr = append(curr, i)
				backtrack(i+1, sum+i)
				curr = curr[:len(curr)-1]
			}
		}
	}
	backtrack(1, 0)
	return result
}
