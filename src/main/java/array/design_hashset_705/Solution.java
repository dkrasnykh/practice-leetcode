package array.design_hashset_705;

class MyLinkedList {
    Integer key;
    MyLinkedList next;

    public MyLinkedList() {
    }

    public MyLinkedList(Integer key) {
        this.key = key;
        this.next = null;
    }
}

class MyHashSet {
    private MyLinkedList[] set;

    public MyHashSet() {
        set = new MyLinkedList[10000];
        for (int i = 0; i < 10000; ++i) {
            set[i] = new MyLinkedList(-1); // dummy key
        }
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        MyLinkedList curr = set[key % set.length];
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new MyLinkedList(key);
    }

    public void remove(int key) {
        MyLinkedList curr = set[key % set.length];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        MyLinkedList curr = set[key % set.length];
        while (curr.next != null) {
            if (curr.next.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }
}
