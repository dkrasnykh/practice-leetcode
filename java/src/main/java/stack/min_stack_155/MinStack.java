package stack.min_stack_155;

import java.util.ArrayDeque;

class MinStack {
    private ArrayDeque<Integer> values;
    private ArrayDeque<Integer> mins;
    public MinStack() {
        values = new ArrayDeque<>();
        mins =new ArrayDeque<>();
    }
    public void push(int val) {
        values.addLast(val);
        if(!mins.isEmpty() && val > mins.getLast()){
            mins.addLast(mins.getLast());
        } else {
            mins.addLast(val);
        }
    }
    public void pop() {
        values.pollLast();
        mins.pollLast();
    }
    public int top() {
        return values.getLast();
    }

    public int getMin() {
        return mins.getLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        //; // return -3
        minStack.pop();
        //minStack.top();    // return 0
        System.out.println(minStack.top());
        //minStack.getMin(); // return -2
        System.out.println(minStack.getMin());
    }
}
