package main

func search1(arr []int, k int) int {
	l, r := 0, len(arr)-1
	for l <= r {
		m := l + (r-l)/2

		if arr[m] == k {
			return m
		}

		if arr[m] >= arr[0] {
			if arr[m] < k || arr[m] > k && k < arr[0] {
				l = m + 1
			} else if arr[m] > k && k >= arr[0] {
				r = m - 1
			}
		} else {
			if arr[m] > k || arr[m] < k && k >= arr[0] {
				r = m - 1
			} else if arr[m] < k && k < arr[0] {
				l = m + 1
			}
		}

	}
	return -1
}
