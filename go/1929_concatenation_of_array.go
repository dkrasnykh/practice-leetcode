package main

func getConcatenation(nums []int) []int {
	ans := make([]int, len(nums)*2)
	p := len(nums)
	for i := 0; i < len(nums); i++ {
		ans[i] = nums[i]
		ans[p+i] = nums[i]
	}
	return ans
}
