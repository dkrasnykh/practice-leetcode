package main

//O(n * 2^n)
func subsets(nums []int) [][]int {
	n := len(nums)
	subset := make([]int, 0)
	result := make([][]int, 0)

	var backtrack func(ind int)
	backtrack = func(i int) {
		if i == n {
			tmp := make([]int, len(subset))
			copy(tmp, subset)
			result = append(result, tmp)
			return
		}
		subset = append(subset, nums[i])
		backtrack(i + 1)
		subset = subset[:len(subset)-1]
		backtrack(i + 1)
	}
	backtrack(0)
	return result
}
