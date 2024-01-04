package main

func minOperations1(nums []int) int {
	op := func(k int) int {
		res := 0
		for k > 1 {
			if k%3 == 0 {
				return res + k/3
			}
			k -= 2
			res += 1
		}
		if k == 1 {
			return -1
		}
		return res
	}
	m := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		m[nums[i]] += 1
	}
	ans := 0
	for _, v := range m {
		o := op(v)
		if o == -1 {
			return -1
		}
		ans += o
	}
	return ans
}
