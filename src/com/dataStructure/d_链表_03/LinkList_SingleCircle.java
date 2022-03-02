package com.dataStructure.d_链表_03;

/**
 * 单向循环链表
 * @param <E>
 */
public class LinkList_SingleCircle<E> {
    private int size;
    private Node<E> first;
    private static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 内部类-链表的节点
     * @param <E>
     */
    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    //// 链表中元素的个数
    public int size() {
        return size;
    }

    //// 判断链表是否为空
    public boolean isEmpaty() {
        return size == 0;
    }

    //// 在链表中查看元素位置
    public int indexOf(E element) {
        Node<E> currentNode = first;
        if (element == null) {                              //注意处理null的情况
            for (int i=0; i<size; i++) {
                if (currentNode.element == null) return i;
                currentNode = currentNode.next;
            }
        }else {
            for (int i=0; i<size; i++) {
                //泛型比较不能直接使用等号（判断内存地址是不是相等）
                //可以重写equals方法
                if (element.equals(currentNode.element)) return i;
                currentNode = currentNode.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    //// 判断链表是否包含某个元素
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    //// 根据下标获取节点
    private Node<E> node(int index){//根据下标获取节点
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("下标异常");
        Node<E> currentNode = first;
        for (int i = 0; i<index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    //// 链表往index位置添加元素
    public void add(int index, E element) {
        if (index == 0) {                                       // 判断是不是第一个
            first = new Node<>(element,first);                  // 最后一个元素应该指向头节点
            Node<E> lastNode = (size == 0) ? first : node(size-1).next;
            lastNode.next = first;
        }else {
            Node<E> preNode = node(index - 1);            // 上一个节点
            preNode.next = new Node<>(element, preNode.next);
        }
        size++;
    }

    //// 添加元素到链表最后面
    public void add(E element) {//添加元素到最后面
        add(size,element);
    }

    //// 清除所有元素
    public void clear() {//清除所有元素
        first = null;
        size = 0;
    }

    //// 链表返回index位置对应的元素
    public E get(int index){
        return node(index).element;
    }

    //// 链表设置index位置的元素，并返回原来元素
    public E set(int index,E element) {
        Node<E> currentNode = node(index);
        E old = currentNode.element;
        currentNode.element = element;
        return old;
    }

    //// 链表删除index位置对应的元素，并返回被删除的节点
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("下标异常");
        Node<E> node = first;
        if (index == 0) {
            if(size == 1) {
                first = null;
            }else {
                Node<E> lastNode = node(size -1);
                first = first.next;
                lastNode.next = first;
            }
        }else {
            Node<E> preNode = node(index-1);
            node = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return node.element;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> currntNode = first;
        for (int i = 0; i < size; i++) {
            string.append(currntNode.element);
            if (i != size-1) {
                string.append(", ");
            }
            currntNode = currntNode.next;
        }
        string.append("]");
        return string.toString();
    }
}
