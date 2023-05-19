package stack.implement_stack_using_queues_225;

import java.util.ArrayDeque;

class MyStack {
    private ArrayDeque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        int n = queue.size();
        for(int i = 0; i < n-1; ++i){
            int x = queue.pollFirst();
            queue.addLast(x);
        }
        return queue.pollFirst();
    }

    public int top() {
        int n = queue.size();
        for(int i = 0; i < n-1; ++i){
            int x = queue.pollFirst();
            queue.addLast(x);
        }
        int top = queue.pollFirst();
        queue.addLast(top);
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
