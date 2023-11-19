package main

func permuteUnique(nums []int) [][]int {
	result := make([][]int, 0)
	curr := make([]int, 0)
	cnt := make(map[int]int, 0)
	for _, n := range nums {
		cnt[n] += 1
	}
	var backtrack func()
	backtrack = func() {
		if len(curr) == len(nums) {
			result = append(result, append([]int{}, curr...))
			return
		}
		for n, _ := range cnt {
			if cnt[n] > 0 {
				curr = append(curr, n)
				cnt[n] -= 1
				backtrack()
				cnt[n] += 1
				curr = curr[:len(curr)-1]
			}
		}
	}
	backtrack()
	return result
}
