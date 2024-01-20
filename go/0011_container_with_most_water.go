package main

func maxArea1(height []int) int {
	l, r := 0, len(height)-1
	ans := 0
	for l < r {
		ans = max(ans, min(height[l], height[r])*(r-l))
		if height[l] < height[r] {
			l += 1
		} else {
			r -= 1
		}
	}
	return ans
}
