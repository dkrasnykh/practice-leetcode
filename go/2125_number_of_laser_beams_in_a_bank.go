package main

func numberOfBeams(bank []string) int {
	prev := 0
	res := 0
	for i := 0; i < len(bank); i++ {
		curr := 0
		for j := 0; j < len(bank[i]); j++ {
			if bank[i][j] == '1' {
				curr += 1
			}
		}
		if curr == 0 {
			continue
		}
		res += curr * prev
		prev = curr
	}
	return res
}
