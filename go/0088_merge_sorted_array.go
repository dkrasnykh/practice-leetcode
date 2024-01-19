package main

func merge(nums1 []int, m int, nums2 []int, n int) {
	tmp := make([]int, m)
	copy(tmp, nums1)
	i, j := 0, 0
	for k := 0; k < m+n; k++ {
		if j == n || i < m && tmp[i] <= nums2[j] {
			nums1[k] = tmp[i]
			i += 1
		} else {
			nums1[k] = nums2[j]
			j += 1
		}
	}
}
