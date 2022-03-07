package com.dataStructure.h_集合_07;

import java.util.LinkedList;
import java.util.List;

/**
 * 使用链表来实现集合
 * @param <E>
 */
public class ListSet<E> implements Set<E> {
    private List<E> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    @Override
    public void add(E element) {
        if(list.contains(element)){             // 添加之前先检查是否存在
            return;
        }
        list.add(element);
    }

    @Override
    public void remove(E element) {
        list.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        if(visitor == null) return;

        int size = list.size();


        for(int i = 0;i < size;i++) {
            visitor.visit(list.get(i));
        }
    }
}
