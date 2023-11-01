package linked_list.lru_cache_146.solution1;

import java.util.Map;
import java.util.HashMap;

//https://www.youtube.com/watch?v=7ABFKPK2hD4
class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node left;
    private Node right;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        //left = LRU, right = most recent
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    // remove node from list
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // insert node at right
    public void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    public int get(int key) {
        if(this.cache.containsKey(key)){
            remove(this.cache.get(key));
            insert(this.cache.get(key));
            return this.cache.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)){
            remove(cache.get(key));
        }
        this.cache.put(key, new Node(key, value));
        this.insert(this.cache.get(key));
        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }


    private class Node {
        private int key;
        private int val;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
