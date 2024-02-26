package main

func isPowerOfTwo(n int) bool {
	x := 1
	for x < n {
		x *= 2
	}
	return x == n
	//return n > 0 && (n & (n - 1)) == 0
	//return n>0 && ((1 << 30)%n) == 0
}
