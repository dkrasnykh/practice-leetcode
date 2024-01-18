package main

func subarraySum(nums []int, k int) int {
	m := map[int]int{0: 1}
	prefix, ans := 0, 0
	for i := 0; i < len(nums); i++ {
		prefix += nums[i]
		if v, ok := m[prefix-k]; ok {
			ans += v
		}
		m[prefix] += 1
	}
	return ans
}
