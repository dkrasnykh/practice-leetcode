package main

func twoSum1(numbers []int, target int) []int {
	l, r := 0, len(numbers)-1
	for l < r {
		if numbers[l]+numbers[r] > target {
			r -= 1
		} else if numbers[l]+numbers[r] < target {
			l += 1
		} else {
			return []int{l + 1, r + 1}
		}
	}
	return []int{}
}
