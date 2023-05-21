package stack.online_stock_span_901.solution2;

import java.util.ArrayDeque;

//https://www.youtube.com/watch?v=slYh0ZNEqSw
public class StockSpanner {
    private ArrayDeque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.getLast()[0] <= price){
            span += stack.pollLast()[1];
        }
        stack.addLast(new int[]{price, span});
        return span;
    }
}
