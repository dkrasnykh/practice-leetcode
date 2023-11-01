package linked_list.lru_cache_146;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class LRUCache {
    private int capacity;
    private int timestamp;
    Map<Integer, Integer> values;
    Map<Integer, Integer> timestamps;
    TreeSet<int[]> states;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.values = new HashMap<>();
        this.timestamps = new HashMap<>();
        this.timestamp = 0;
        this.states = new TreeSet<>((e1,e2) -> (e1[1] == e2[1] ? e1[0] - e2[0] : e1[1] - e2[1]));
    }

    public int get(int key) {
        if(values.containsKey(key)){
            this.states.remove(new int[]{key, this.timestamps.get(key)});
            this.timestamps.put(key, this.timestamp);
            this.states.add(new int[]{key, this.timestamp});
            this.timestamp += 1;
            return values.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(values.containsKey(key)){
            this.states.remove(new int[]{key, this.timestamps.get(key)});
            this.timestamps.put(key, this.timestamp);
            this.values.put(key, value);
            this.states.add(new int[]{key, this.timestamp});
        } else {
            if(values.size() == this.capacity){
                int[] lru = states.pollFirst();
                this.values.remove(lru[0]);
                this.timestamps.remove(lru[0]);
            }
            this.timestamps.put(key, this.timestamp);
            this.values.put(key, value);
            this.states.add(new int[]{key, this.timestamp});
        }
        this.timestamp += 1;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));  // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2)); // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));  // return -1 (not found)
        System.out.println(lRUCache.get(3));  // return 3
        System.out.println(lRUCache.get(4));  // return 4
    }
}
