package linked_list.design_linked_list_707;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyLinkedList {
    ListNode head = null;
    ListNode tail = null;
    int size;

    public MyLinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            if (size - index < index) {
                int i = size - 1;
                ListNode cur = tail;
                while (i > index) {
                    cur = cur.prev;
                    i -= 1;
                }
                return cur.val;
            } else {
                int i = 0;
                ListNode cur = head;
                while (i < index) {
                    cur = cur.next;
                    i += 1;
                }
                return cur.val;
            }
        }
    }

    public void addAtHead(int val) {
        ListNode tmp = head;
        head = new ListNode(val, null, tmp);
        if(tmp != null){
            tmp.prev = head;
        }
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void addAtTail(int val) {
        ListNode tmp = tail;
        tail = new ListNode(val, tmp, null);
        if(tmp != null){
            tmp.next = tail;
        }
        if (head == null) {
            head = tail;
        }
        size += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= size) {
            ListNode prev, next;
            if (index == size) {
                prev = tail;
                next = null;
            } else if (size - index < index) {
                int i = size - 1;
                ListNode cur = tail;
                while (i > index) {
                    cur = cur.prev;
                    i -= 1;
                }
                prev = cur.prev;
                next = cur;
            } else {
                int i = 0;
                ListNode cur = head;
                while (i < index) {
                    cur = cur.next;
                    i += 1;
                }
                prev = cur.prev;
                next = cur;
            }
            ListNode node = new ListNode(val, prev, next);
            if (prev != null) {
                prev.next = node;
            } else {
                head = node;
            }
            if (next != null) {
                next.prev = node;
            } else {
                tail = node;
            }
            size += 1;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            ListNode prev, next;
            if (size - index < index) {
                int i = size - 1;
                ListNode cur = tail;
                while (i > index) {
                    cur = cur.prev;
                    i -= 1;
                }
                prev = cur.prev;
                next = cur.next;
                cur.prev = null;
                cur.next = null;
            } else {
                int i = 0;
                ListNode cur = head;
                while (i < index) {
                    cur = cur.next;
                    i += 1;
                }
                prev = cur.prev;
                next = cur.next;
                cur.prev = null;
                cur.next = null;
            }
            if (prev != null) {
                prev.next = next;
            } else {
                head = next;
            }
            if (next != null) {
                next.prev = prev;
            } else {
                tail = prev;
            }
            size -= 1;
        }
    }
}
