package main

import (
	"sort"
)

func subsetsWithDup(nums []int) [][]int {
	//сортировать nums, чтобы исключить дубли
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})

	result := make([][]int, 0)
	subset := make([]int, 0)

	var backtrack func(ind int)
	backtrack = func(ind int) {
		if ind == len(nums) {
			tmp := make([]int, len(subset))
			copy(tmp, subset)
			result = append(result, tmp)
			return
		}
		subset = append(subset, nums[ind])
		backtrack(ind + 1)
		tmp := subset[len(subset)-1]
		subset = subset[:len(subset)-1]
		//когда пропускаем элемент, нужно так же пропустить все его дубли, которые идут подряд
		for ind < len(nums)-1 && nums[ind+1] == tmp {
			ind += 1
		}
		backtrack(ind + 1)
	}
	backtrack(0)
	return result
}
