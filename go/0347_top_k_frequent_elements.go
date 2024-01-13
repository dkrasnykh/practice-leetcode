package main

func topKFrequent(nums []int, k int) []int {
	cnt := make(map[int]int)
	size := 0
	for i := 0; i < len(nums); i++ {
		cnt[nums[i]] += 1
		size = max(size, cnt[nums[i]])
	}
	bucket := make([][]int, size)
	for key, _ := range cnt {
		i := cnt[key]
		if bucket[i] == nil {
			bucket[i] = make([]int, 0)
		}
		bucket[i] = append(bucket[i], key)
	}
	ans := make([]int, 0)
	for i := size - 1; i >= 0; i-- {
		if bucket[i] != nil {
			j := 0
			for j < len(bucket[i]) && k > 0 {
				ans = append(ans, bucket[i][j])
				j += 1
				k -= 1
			}
		}
		if k == 0 {
			break
		}
	}
	return ans
}
