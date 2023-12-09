package main

func replaceElements(arr []int) []int {
	rightMax := -1
	for i := len(arr) - 1; i >= 0; i-- {
		tmp := arr[i]
		arr[i] = rightMax
		rightMax = max(rightMax, tmp)
	}
	return arr
}
