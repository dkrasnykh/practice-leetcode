package design.flatten_nested_list_iterator_341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> values;
    int pointer;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.values = new ArrayList<>();
        this.pointer = 0;
        this.init(nestedList);
    }

    @Override
    public Integer next() {
        Integer value = values.get(pointer);
        pointer += 1;
        return value;
    }

    @Override
    public boolean hasNext() {
        return pointer < values.size();
    }

    private void init(List<NestedInteger> nestedList) {
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                values.add(e.getInteger());
            } else {
                this.init(e.getList());
            }
        }
    }
}

