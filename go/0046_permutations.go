package main

func permute(nums []int) [][]int {
	result := make([][]int, 0)
	used := make([]bool, len(nums))
	p := make([]int, 0)

	var backtrack func()
	backtrack = func() {
		if len(p) == len(nums) {
			tmp := make([]int, len(p))
			copy(tmp, p)
			result = append(result, tmp)
			return
		}
		for i := 0; i < len(nums); i++ {
			if used[i] {
				continue
			}
			used[i] = true
			p = append(p, nums[i])
			backtrack()
			p = p[:len(p)-1]
			used[i] = false
		}
	}
	backtrack()
	return result
}
