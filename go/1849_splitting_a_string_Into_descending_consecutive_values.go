package main

import (
	"strconv"
)

func splitString(s string) bool {

	nums := make([]string, 0)
	curr := make([]byte, 0)

	var backtrack func(ind int) bool
	backtrack = func(ind int) bool {
		if ind == len(s) && len(nums) <= 1 {
			return false
		}
		if ind == len(s) {
			return true
		}

		for i := ind; i < len(s); i++ {
			curr = append(curr, s[i])
			n, _ := strconv.Atoi(string(curr))
			if len(nums) == 0 && n > 0 {
				nums = append(nums, string(curr))
				curr = make([]byte, 0)

				if backtrack(i + 1) {
					return true
				}

				tmp := make([]byte, 0)
				copy(tmp, curr)
				curr = make([]byte, 0)
				curr = append(curr, nums[len(nums)-1]...)
				curr = append(curr, tmp...)
				nums = nums[:len(nums)-1]
			}
			if len(nums) > 0 {
				last, _ := strconv.Atoi(string(nums[len(nums)-1]))
				if last < n {
					return false
				}
				if last-n == 1 {
					nums = append(nums, string(curr))
					curr = make([]byte, 0)
					if backtrack(i + 1) {
						return true
					}
					tmp := make([]byte, 0)
					copy(tmp, curr)
					curr = make([]byte, 0)
					curr = append(curr, nums[len(nums)-1]...)
					curr = append(curr, tmp...)
					nums = nums[:len(nums)-1]
				}
			}
		}
		return false
	}
	return backtrack(0)
}
