package main

// Time Limit
func sumSubarrayMins(arr []int) int {
	ans := 0
	for i := 0; i < len(arr); i++ {
		currMin := arr[i]
		for j := i; j < len(arr); j++ {
			currMin = min(currMin, arr[j])
			ans = (ans + (currMin)%mod) % mod
		}
	}
	return ans
}
