package stack.baseball_game_682;

import java.util.ArrayDeque;

public class Solution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int a, b, total = 0;
        for (String o : operations) {
            switch (o) {
                case "+":
                    a = stack.pollLast();
                    b = stack.getLast();
                    stack.addLast(a);
                    stack.addLast(a + b);
                    total += (a + b);
                    break;
                case "D":
                    a = stack.getLast();
                    stack.addLast(2 * a);
                    total += 2 * a;
                    break;
                case "C":
                    total -= stack.pollLast();
                    break;
                default:
                    stack.addLast(Integer.parseInt(o));
                    total += Integer.parseInt(o);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
