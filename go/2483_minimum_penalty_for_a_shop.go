package main

func bestClosingTime(customers string) int {
	n := len(customers)
	prefix := make([]int, n+1)
	prefix[0] = 0
	for i := 1; i <= n; i++ {
		prefix[i] = prefix[i-1]
		if customers[i-1] == 'Y' {
			prefix[i] += 1
		}
	}
	penalty, j := n, 0
	for i := 0; i <= n; i++ {
		curr := i - 2*prefix[i] + prefix[n]
		if curr < penalty {
			penalty = curr
			j = i
		}
	}
	return j
}
