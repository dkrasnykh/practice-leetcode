package main

func findMatrix(nums []int) [][]int {
	m := make(map[int]int)
	rows := 0
	for _, n := range nums {
		m[n] += 1
		rows = max(rows, m[n])
	}
	result := make([][]int, 0, rows)
	for rows > 0 {
		tmp := make([]int, 0)
		for k := range m {
			if m[k] > 0 {
				tmp = append(tmp, k)
				m[k] -= 1
			}
		}
		result = append(result, tmp)
		rows -= 1
	}
	return result
}
