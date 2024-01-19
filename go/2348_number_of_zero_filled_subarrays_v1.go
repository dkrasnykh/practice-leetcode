package main

func zeroFilledSubarray1(nums []int) int64 {
	var res, cnt int64
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			cnt += 1
		} else {
			cnt = 0
		}
		res += cnt
	}
	return res
}
