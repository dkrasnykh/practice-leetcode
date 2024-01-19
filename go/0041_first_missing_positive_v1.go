package main

func firstMissingPositive1(nums []int) int {
	n := len(nums)
	for i := 0; i < n; i++ {
		if nums[i] < 0 {
			nums[i] = 0
		}
	}

	value := func(val int) int {
		if val < 0 {
			return -val
		}
		return val
	}

	for i := 0; i < n; i++ {
		v := value(nums[i])
		if v > 0 && v <= n {
			ind := v - 1
			if nums[ind] == 0 {
				nums[ind] = -(ind + 1)
			} else if nums[ind] > 0 {
				nums[ind] = -nums[ind]
			}
		}
	}
	for i := 0; i < n; i++ {
		if nums[i] >= 0 {
			return i + 1
		}
	}
	return n + 1
}
