package binary_search.time_based_key_value_store_981.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

//https://www.youtube.com/watch?v=fu2cD_6E8Hw
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

    HashMap<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair<String, Integer>> list = map.get(key);
        return search(list, timestamp);
    }

    public String search(List<Pair<String, Integer>> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (list.get(mid).getSecond() <= timestamp) start = mid; else end =
                    mid - 1;
        }
        return list.get(start).getSecond() <= timestamp
                ? list.get(start).getFirst()
                : "";
    }
}

