package main

import "sort"

const mod int = 1e9 + 7

func fastPow(x, n int) int {
	if n == 0 {
		return 1
	}
	y := fastPow(x, n/2)
	if n%2 == 1 {
		return (((y * y) % mod) * x) % mod
	}
	return (y * y) % mod
}

// modular arithmetic :
// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/solutions/3492235/golang-sorting-two-pointers/
func numSubseq(nums []int, target int) int {
	sort.Ints(nums)
	res, r := 0, len(nums)-1
	for l := 0; l < len(nums); l++ {
		for r >= 0 && l < len(nums) && nums[r]+nums[l] > target {
			r -= 1
		}
		if r < l {
			break
		}
		p := r - l
		res = (res + fastPow(2, p)) % mod
	}
	return res
}
