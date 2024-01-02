package main

func findMatrix1(nums []int) [][]int {
	count := make(map[int]int)
	res := make([][]int, 0)

	for _, n := range nums {
		row := count[n]
		if len(res) == row {
			res = append(res, []int{})
		}
		res[row] = append(res[row], n)
		count[n] += 1
	}
	return res
}
