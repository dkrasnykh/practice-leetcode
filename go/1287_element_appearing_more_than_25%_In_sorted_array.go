package main

func findSpecialInteger(arr []int) int {
	maxLen := 0
	maxVal := -1
	length := 1
	for i := 1; i <= len(arr); i++ {
		if (i == len(arr)) || (arr[i] != arr[i-1]) {
			if maxLen < length {
				maxLen = length
				maxVal = arr[i-1]
			}
			length = 1
		} else {
			length += 1
		}
	}
	return maxVal
}
