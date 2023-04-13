package binary_search.time_based_key_value_store_981;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

class Pair<T, V> {
    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}

class TimeMap {
    private TreeMap<Pair<String, Integer>, String> treeMap;

    public TimeMap() {
        treeMap = new TreeMap<>((a, b) -> a.getFirst().equals(b.getFirst()) ? a.getSecond() - b.getSecond() : a.getFirst().compareTo(b.getFirst()));
    }

    public void set(String key, String value, int timestamp) {
        treeMap.put(new Pair(key, timestamp), value);
    }

    public String get(String key, int timestamp) {
        Map.Entry<Pair<String, Integer>, String> e = treeMap.floorEntry(new Pair<>(key, timestamp));
        return (e != null) ? (e.getKey().getFirst().equals(key)) ? e.getValue() : "" : "";
    }
}


public class Solution {

    public static void main(String[] args) {
        TimeMap map = new TimeMap();
        /*
        map.set("foo", "bar", 1);
        System.out.println(map.get("foo", 1));
        System.out.println(map.get("foo", 3));
        map.set("foo", "bar2", 4);
        System.out.println(map.get("foo", 4));
        System.out.println(map.get("foo", 5));

        map.set("love","high",10);
        map.set("love","low",20);
        System.out.println(map.get("love",5));
        System.out.println(map.get("love",10));
        System.out.println(map.get("love",15));
        System.out.println(map.get("love",20));
        System.out.println(map.get("love",25));
        */
        map.set("a", "bar", 1);
        map.set("x", "b", 3);
        System.out.println(map.get("b", 3));
        map.set("foo", "bar2", 4);
        System.out.println(map.get("foo", 4));
        System.out.println(map.get("foo", 5));
    }
}
