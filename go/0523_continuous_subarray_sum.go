package main

func checkSubarraySum(nums []int, k int) bool {
	m := map[int]int{0: -1}
	total := 0
	for i := 0; i < len(nums); i++ {
		total += nums[i]
		if _, ok := m[total%k]; !ok {
			m[total%k] = i
		} else if i-m[total%k] >= 2 {
			return true
		}
	}
	return false
}
