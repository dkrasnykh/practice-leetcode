package main

//  https://www.youtube.com/watch?v=Dle_SpjHTio

func beautifulSubsets(nums []int, k int) int {
	count := map[int]int{}
	var helper func(i int, count map[int]int) int
	helper = func(i int, count map[int]int) int {
		if i == len(nums) {
			return 1
		}
		res := helper(i+1, count)
		if count[nums[i]+k] <= 0 && count[nums[i]-k] <= 0 {
			count[nums[i]] += 1
			res += helper(i+1, count)
			count[nums[i]] -= 1
		}
		return res
	}
	return helper(0, count) - 1
}
