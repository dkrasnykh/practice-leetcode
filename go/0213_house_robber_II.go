package main

//func rob(nums []int) int
func rob1(nums []int) int {
	n := len(nums)
	//[rob1, rob2, n, n+1, ...]
	helper := func(l, r int) int {
		rob1, rob2 := 0, 0
		for i := l; i < r; i++ {
			tmp := max(rob2, rob1+nums[i])
			rob1 = rob2
			rob2 = tmp
		}
		return rob2
	}
	tmp := max(helper(0, n-1), helper(1, n))
	return max(nums[0], tmp)
}
