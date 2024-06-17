package main

func numIdenticalPairs(nums []int) int {
	cnt := make(map[int]int, len(nums))
	res := 0
	for _, n := range nums {
		res += cnt[n]
		cnt[n] += 1
	}
	return res
}
