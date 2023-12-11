package main

func generate(numRows int) [][]int {
	result := make([][]int, 0)
	result = append(result, []int{1})
	for i := 1; i < numRows; i++ {
		curr := make([]int, 0, len(result[i-1])+1)
		curr = append(curr, 1)
		for j := 0; j < len(result[i-1])-1; j++ {
			curr = append(curr, result[i-1][j]+result[i-1][j+1])
		}
		curr = append(curr, 1)
		result = append(result, curr)
	}
	return result
}
