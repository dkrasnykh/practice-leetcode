package linked_list.lfu_cache_460;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

class Tuple {
    int key;
    int cnt;
    int timestamp;

    public Tuple(int key, int cnt, int timestamp) {
        this.key = key;
        this.cnt = cnt;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return key == tuple.key && cnt == tuple.cnt && timestamp == tuple.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, cnt, timestamp);
    }
}

class LFUCache {
    private int capacity;
    private int timestamp;
    Map<Integer, Integer> values;
    Map<Integer, Integer> count;
    Map<Integer, Integer> timestamps;
    TreeSet<Tuple> states;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.timestamp = 0;
        this.values = new HashMap<>();
        this.count = new HashMap<>();
        this.timestamps = new HashMap<>();
        this.states = new TreeSet<>((e1, e2) -> e1.cnt == e2.cnt ? e1.timestamp - e2.timestamp : e1.cnt - e2.cnt);
    }

    public int get(int key) {
        if (values.containsKey(key)) {
            this.states.remove(new Tuple(key, count.get(key), timestamps.get(key)));
            this.count.compute(key, (k, v) -> v + 1);
            this.timestamps.put(key, this.timestamp);
            this.states.add(new Tuple(key, count.get(key), timestamps.get(key)));
            this.timestamp += 1;
            return values.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (values.containsKey(key)) {
            this.states.remove(new Tuple(key, count.get(key), timestamps.get(key)));
            this.count.compute(key, (k, v) -> v + 1);
            this.timestamps.put(key, this.timestamp);
            this.values.put(key, value);
            this.states.add(new Tuple(key, count.get(key), timestamps.get(key)));
            this.timestamp += 1;
        } else {
            if (this.values.size() == this.capacity) {
                Tuple lru = this.states.pollFirst();
                this.values.remove(lru.key);
                this.count.remove(lru.key);
                this.timestamps.remove(lru.key);
            }
            this.values.put(key, value);
            this.count.put(key, 1);
            this.timestamps.put(key, timestamp);
            this.states.add(new Tuple(key, count.get(key), timestamps.get(key)));
            this.timestamp += 1;
        }
    }

    public static void main(String[] args) {
        // cnt(x) = the use counter for key x
        // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        //lfu.get(1);      // return 1
        System.out.println(lfu.get(1)); // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4)); // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
