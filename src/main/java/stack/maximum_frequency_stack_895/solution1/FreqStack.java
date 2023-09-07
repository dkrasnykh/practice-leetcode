package stack.maximum_frequency_stack_895.solution1;

import java.util.*;

//https://www.youtube.com/watch?v=Z6idIicFDOE
class FreqStack {
    Map<Integer, Integer> cnt;
    int maxCnt;
    Map<Integer, ArrayDeque<Integer>> stacks;
    public FreqStack() {
        this.cnt = new HashMap<>();
        this.maxCnt = 0;
        this.stacks = new HashMap<>();
    }

    public void push(int val) {
        int valCnt = 1 + cnt.getOrDefault(val, 0);
        cnt.put(val, valCnt);
        if(valCnt > maxCnt){
            maxCnt = valCnt;
            stacks.put(valCnt, new ArrayDeque<>());
        }
        stacks.get(valCnt).addLast(val);
    }

    public int pop() {
        int result = stacks.get(maxCnt).pollLast();
        cnt.compute(result, (k, v) -> v - 1);
        if(stacks.get(maxCnt).isEmpty()){
            maxCnt -= 1;
        }
        return result;
    }
}
