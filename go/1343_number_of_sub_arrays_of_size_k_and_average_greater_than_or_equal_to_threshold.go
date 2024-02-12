package main

func numOfSubarrays(arr []int, k int, threshold int) int {
	total, res := 0, 0
	for i := 0; i < len(arr); i++ {
		total += arr[i]
		if i >= k {
			total -= arr[i-k]
		}
		if i >= k-1 && total/k >= threshold {
			res += 1
		}
	}
	return res
}
