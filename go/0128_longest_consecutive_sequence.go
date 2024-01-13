package main

func longestConsecutive(nums []int) int {
	set := map[int]bool{}
	for i := 0; i < len(nums); i++ {
		set[nums[i]] = true
	}
	ans := 0
	for i := 0; i < len(nums); i++ {
		if !set[nums[i]-1] {
			length := 1
			for set[nums[i]+length] {
				length += 1
			}
			ans = max(ans, length)
		}
	}
	return ans
}
