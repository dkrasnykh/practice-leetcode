package stack.maximum_frequency_stack_895;

import java.util.*;

//Time Limit Exceeded  33 test
class Tuple {
    int val;
    int freq;
    int prior;

    public Tuple(int val, int freq, int prior) {
        this.val = val;
        this.freq = freq;
        this.prior = prior;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return val == tuple.val && freq == tuple.freq && prior == tuple.prior;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, freq, prior);
    }
}
public class FreqStack {
    int timestamp;
    TreeSet<Tuple> stack;
    Map<Integer, List<Integer>> values; //нужно сохранять список таймстампов - количсетво элементов и будет частотой
    public FreqStack() {
        this.timestamp = 0;
        //val, freq, prior
        this.stack = new TreeSet<>((t1,t2)->(t1.freq == t2.freq ? t2.prior - t1.prior : t2.freq - t1.freq));
        this.values = new HashMap<>();
    }

    public void push(int val) {
        if(values.containsKey(val)){
            List<Integer> timestamps = values.get(val);
            for(Integer timestamp : timestamps){
                stack.remove(new Tuple(val, timestamps.size(), timestamp));
            }
            timestamps.add(timestamp);
            for(Integer timestamp : timestamps){
                stack.add(new Tuple(val, timestamps.size(), timestamp));
            }
            values.replace(val, timestamps);
        } else {
            values.put(val, new ArrayList<>(List.of(timestamp)));
            stack.add(new Tuple(val, 1, timestamp));
        }
        timestamp += 1;
    }

    public int pop() {
        Tuple popped = stack.first();
        List<Integer> timestamps = values.get(popped.val);
        for(Integer timestamp : timestamps){
            stack.remove(new Tuple(popped.val, popped.freq, timestamp));
        }
        timestamps.remove(timestamps.size() - 1);
        for(Integer timestamp : timestamps){
            stack.add(new Tuple(popped.val, timestamps.size(), timestamp));
        }
        return popped.val;
    }

    public static void main(String[] args) {
        //10^4
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println(freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}
