package main

func combine(n int, k int) [][]int {
	result := make([][]int, 0)
	curr := make([]int, 0)

	var backtrack func(ind int)
	backtrack = func(ind int) {
		if len(curr) == k {
			result = append(result, append([]int{}, curr...))
			return
		}
		for i := ind; i <= n; i++ {
			curr = append(curr, i)
			backtrack(i + 1)
			curr = curr[:len(curr)-1]
		}
	}
	backtrack(1)
	return result
}
