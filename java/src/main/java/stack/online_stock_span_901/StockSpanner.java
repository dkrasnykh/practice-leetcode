package stack.online_stock_span_901;

import java.util.ArrayList;
import java.util.List;

class StockSpanner {
    private List<int[]> values;
    public StockSpanner() {
        values = new ArrayList<>();
    }
    public int next(int price) {
        int span = 1;
        int prev = values.size() - 1;
        while (prev >= 0 && values.get(prev)[0] <= price) {
            int ind = values.get(prev)[1];
            span += (prev - ind);
            prev = ind;
        }
        values.add(new int[]{price, values.size() - span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));

        /*
        System.out.println(stockSpanner.next(30));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
        */
    }
}
