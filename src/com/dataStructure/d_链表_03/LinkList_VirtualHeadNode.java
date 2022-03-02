package com.dataStructure.d_链表_03;

/**
 * 添加虚拟头节点，这样就不需要再单独处理头节点了，代码更加精简
 * @param <E>
 */
public class LinkList_VirtualHeadNode<E> {

    //添加一个构造函数，创建链表的时候就有一个虚拟头节点了
    public LinkList_VirtualHeadNode(){
        first = new Node<>(null, null);
    }

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
        Node<E> currentNode = first.next;                   // 注意这里first指向了虚拟头节点，所以遍历应该从first.next开始
        if (element == null) {                              // 注意处理null的情况
            for (int i=0; i<size; i++) {
                if (currentNode.element == null) return i;
                currentNode = currentNode.next;
            }
        }else {
            for (int i=0;i<size;i++) {
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
    private Node<E> node(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("下标异常");
        Node<E> currentNode = first.next;       // first代表虚拟头节点，这里第一个元素就是first.next
        for (int i = 0; i<index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    //// 链表往index位置添加元素
    public void add(int index, E element) {
        //判断是不是第一个
//		if (index == 0) {
//			first = new Node<>(element,first);
//		}else {
//			Node<E> preNode = node(index - 1);//上一个节点
//			preNode.next = new Node<>(element, preNode.next);
//		}

        //使用虚拟头节点，这里就不需要单独判断是不是第一个了
        Node<E> preNode = index == 0 ? first : node(index - 1);//上一个节点
        preNode.next = new Node<>(element, preNode.next);
        size++;
    }

    //// 添加元素到链表最后面
    public void add(E element) {
        add(size,element);
    }

    //// 清除所有元素
    public void clear() {
        //first = null;
        //使用虚拟头节点，清除的时候就要将虚拟头节点的next指向null
        first.next = null;
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
//		Node<E> node = first;
//		if (index == 0) {
//			first = first.next;
//		}else {
//			Node<E> preNode = node(index-1);
//			node = preNode.next;
//			preNode.next = preNode.next.next;
//		}

        Node<E> preNode = index == 0 ? first : node(index-1);//前一个节点
        Node<E> node = preNode.next;//当前节点
        preNode.next = preNode.next.next;

        size--;
        return node.element;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> currntNode = first.next;//first是虚拟的
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
