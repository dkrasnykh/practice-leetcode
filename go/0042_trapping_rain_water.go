package main

func trap(height []int) int {
	n := len(height)
	leftMax := make([]int, n)
	rightMax := make([]int, n)

	rightMax[n-1] = height[n-1]
	for i := n - 2; i >= 0; i-- {
		rightMax[i] = max(rightMax[i+1], height[i])
	}
	leftMax[0] = height[0]
	for i := 1; i < n; i++ {
		leftMax[i] = max(leftMax[i-1], height[i])
	}
	res := 0
	for i := 0; i < n; i++ {
		res += max(0, min(leftMax[i], rightMax[i])-height[i])
	}
	return res
}
