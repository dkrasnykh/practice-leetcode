package sliding_window.best_time_to_buy_and_sell_stock_121;

//https://www.youtube.com/watch?v=1pkOgXD63yU
public class Solution1 {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;
        while(r < prices.length){
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r += 1;
        }
        return maxP;
    }

    public static void main(String[] args) {

    }
}
