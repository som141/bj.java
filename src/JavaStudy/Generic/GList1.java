package JavaStudy.Generic;

import java.util.ArrayList;
import java.util.List;

public class GList1<T> implements List1<T>{
    private final List<T> list;

    public GList1() {
        this.list = new ArrayList<T>();
    }

    @Override
    public void push(T data) {
        list.add(data);
    }

    @Override
    public T pop() {
        return list.get(list.size()-1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void printList() {
        list.forEach(System.out::println);
    }
}
