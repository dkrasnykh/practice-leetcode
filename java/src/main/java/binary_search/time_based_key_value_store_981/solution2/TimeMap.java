package binary_search.time_based_key_value_store_981.solution2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
class TimeMap {
    Map<String, List<Integer>> timestamps;
    Map<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(values.containsKey(key)){
            values.get(key).add(value);
            timestamps.get(key).add(timestamp);
        } else {
            List<Integer> newTimetsamps = new ArrayList<>(List.of(timestamp));
            timestamps.put(key, newTimetsamps);
            List<String> newValues = new ArrayList<>(List.of(value));
            values.put(key, newValues);
        }
    }

    public String get(String key, int timestamp) {
        if(!values.containsKey(key)){
            return "";
        } else {
            List<Integer> curr = timestamps.get(key);
            int l = 0, r = curr.size() - 1;
            while(l <= r){
                int m = l + (r - l)/2;
                if(curr.get(m).compareTo(timestamp) <= 0){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return r == -1 ? "" : values.get(key).get(r);
        }
    }
}
