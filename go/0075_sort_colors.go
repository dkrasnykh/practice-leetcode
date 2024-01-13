package main

func sortColors(nums []int) {
	partition := func(i, c int) int {
		l := i
		for r := i; r < len(nums); r++ {
			if nums[r] == c {
				nums[l], nums[r] = nums[r], nums[l]
				l += 1
			}
		}
		return l
	}
	partition(partition(0, 0), 1)

}

func sortColors1(nums []int) {
	l, r := 0, len(nums)-1
	for i := 0; i < len(nums); {
		if nums[i] == 0 {
			nums[l], nums[i] = nums[i], nums[l]
			l += 1
			i += 1
		} else if nums[i] == 2 && i < r {
			nums[i], nums[r] = nums[r], nums[i]
			r -= 1
		} else {
			i++
		}
	}
}
