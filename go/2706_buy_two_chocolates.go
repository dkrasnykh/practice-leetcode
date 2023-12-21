package main

func buyChoco(prices []int, money int) int {
	min1, min2 := min(prices[0], prices[1]), max(prices[0], prices[1])
	for i := 2; i < len(prices); i++ {
		if prices[i] < min1 {
			min2 = min1
			min1 = prices[i]
		} else if prices[i] < min2 {
			min2 = prices[i]
		}
	}
	if min1+min2 <= money {
		return money - (min1 + min2)
	}
	return money
}
