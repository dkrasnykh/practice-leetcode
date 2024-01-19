package main

func maxProfit1(prices []int) int {
	buy := prices[0]
	profit := 0
	for i := 0; i < len(prices); i++ {
		profit = max(profit, prices[i]-buy)
		buy = min(buy, prices[i])
	}
	return profit
}
