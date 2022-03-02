package com.dataStructure.c_动态数组_02;

// int size();元素的数量
// boolean isEmpaty();是否为空
// E get(int index);返回index位置对应的元素
// E set(int index, E element);设置index位置的元素，并返回原来元素
// int indexOf(E element);查看元素位置
// boolean contains(E element);是否包含某个元素
// void clear();清除所有元素
// void add(int index, E element);往index位置添加元素
// void add(E element);添加元素到最后面
// E remove(int index);删除index位置对应的元素


/**
 * 动态数组-元素为int型
 */
public class ArrayList {

    private int size;                                       // 元素的数量
    private int[] elements;                                 // 所有元素
    private static final int DEFAULT_CAPATICY = 4;          // 数组默认大小
    private static final int ELEMENT_NOT_FOUND = -1;        // 未找到

    //// 带参数的构造方法
    public ArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPATICY) ? DEFAULT_CAPATICY : capaticy;
        elements = new int[capaticy];
    }

    //// 不带参数的构造方法
    public ArrayList() {
        this(DEFAULT_CAPATICY);
    }

    //// 获取数组中元素的个数
    public int size() {
        return size;
    }

    //// 数组是否为空
    public boolean isEmpaty(){
        return size == 0;
    }

    //// 返回index位置对应的元素
    public int get(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("下标异常");
        return elements[index];
    }

    //// 设置index位置的元素，并返回原来元素
    public int set(int index, int element){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("下标异常");
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    //// 查看元素位置
    public int indexOf(int element){
        for (int i=0; i<size-1; i++) {
            if (elements[i] == element) return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    //// 是否包含某个元素
    public boolean contains(int element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    //// 清除所有元素
    public void clear(){
        size = 0;
    }

    //// 往index位置添加元素
    public void add(int index,int element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("下标异常");
        ensureCapacity(size+1);             // 扩容
        for (int i = size-1;i>=index;i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    //// 添加元素到最后面
    public void add(int element) {
        add(size,element);
    }

    //// 删除index位置对应的元素
    public int remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("下标异常");
        int old = elements[index];
        for (int i = index+1; i<size; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        return old;
    }

    //// 动态数组的扩容
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;                      //数组的容量
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);     //1.5倍
        int[] newElements = new int[newCapacity];
        for(int i = 0; i<size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容成功为：" + newCapacity);
    }

    //// 自定义打印数组
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i != size-1) {
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }
}
