package main

type NumArray struct {
	prefix []int64
}

func Constructor4(nums []int) NumArray {
	prefix := make([]int64, len(nums)+1)
	prefix[0] = 0
	for i := 1; i <= len(nums); i++ {
		prefix[i] = prefix[i-1] + int64(nums[i-1])
	}
	return NumArray{prefix: prefix}
}

func (this *NumArray) SumRange(left int, right int) int {
	return int(this.prefix[right+1] - this.prefix[left])
}
