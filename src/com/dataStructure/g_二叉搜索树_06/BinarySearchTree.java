package com.dataStructure.g_二叉搜索树_06;

/**
 * 二叉搜索树
 * @param <E>
 */
//public class BinarySearchTree<E extends Comparable>{//第一种方法
public class BinarySearchTree<E> {//第二种方法
    private Comparator<E> comparator;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {
        this(null);
    }

    /**
     * 内部类-二叉搜索树的节点
     * @param <E>
     */
    private static class Node<E>{
        E element;                                      // 节点存放的元素
        Node<E> left;                                   // 左节点
        Node<E> right;                                  // 右节点
        Node<E> parent;                                 // 父节点
        public Node(E element, Node<E> parent){         // 节点的构造方法
            this.element = element;
            this.parent = parent;
        }
    }
    private int size;                                   // 二叉搜索树的节点数量
    private Node<E> root;                               // 二叉搜索树的根节点

    /**
     * 返回二叉搜索树的节点数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断二叉树搜索树是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空二叉搜索树
     */
    public void clear() {
        root = null;                                // 直接将根节点置空即可
        size = 0;                                   // 节点大小清零
    }

    /**
     * 二叉搜索树-添加元素
     * @param element
     */
    public void add(E element){
        elementNotNullCheck(element);

        // 根节点要特殊处理
        if(size == 0 || root == null){
            root = new Node(element,null);
            size++;
            return;
        }

        // 其他子节点
        Node<E> node = root;                        // 从根节点开始找
        Node<E> parent = null;
        int cmp = 0;

        while (node != null){
            cmp = compare(element, node.element);   // 比较大小，决定往左还是往右
            parent = node;

            if(cmp > 0){                            // 插入元素比较大，往右找
                node = node.right;
            }else if(cmp <0){                       // 插入元素比较小，往左找
                node = node.left;
            }else{                                  // 相等，可以定义自己的规则，这里采用覆盖
                node.element = element;
            }
        }

        // 走到这里说明找到了要插入在哪个节点后（parent）
        // 加在parent的左边还是右边（cmp）
        if(cmp >0){                                 // 加在parent的右边
            parent.right = new Node<>(element,parent);
        }else{                                      // 加在parent的左边
            parent.left = new Node<>(element,parent);
        }
        size++;
    }

    /**
     * 二叉搜索树-删除元素
     * @param element
     */
    public void remove(E element){
        //1、删除度为0的节点（叶子节点）直接删除
        //node == node.parent.left	->  node.parent.left = null
        //node == node.parent.right ->	node.parent.right = null
        //node.parent == null		->	root = null

        //2、删除度为1的节点，用子节点替代原节点的位置（注意区分左右和根）
        //child是node.left 或者 child是node.right
        //如果node是左节点		->	child.parent = node.parent && node.parent.left = child
        //如果node是右节点		->	child.parent = node.parent && node.parent.right = child
        //如果node是根节点		->	child.parent = null && root = child

        //3、删除度为2的节点，先用前驱或者后继节点的值覆盖原节点的值，删除然后相应的前驱/后继

        remove(node(element));
    }

    /**
     * 二叉搜索树-删除节点
     * @param node
     */
    public void remove(Node<E> node){
        if(node == null){
            return;
        }
        size--;

        if(node.left != null && node.right != null){    // node的度为2
            //找到后继---> 度为2的节点肯定会有前驱和后继
            Node<E> succNode = successor(node);
            node.element = succNode.element;            // 使用后继节点的值覆盖度为2的节点的值
            node = succNode;                            // 删除后继节点（度为2的节点的前驱或者后继的度只可能为0或1）
        }

        // 删除node节点
        Node<E> replacementNode = node.left != null ? node.left : node.right;

        if(replacementNode != null) {                   // node是度为1的
            replacementNode.parent = node.parent;       // 替换节点的父节点要修改
                                                        // 替换节点的父节点的子节点要修改
            if(node.parent == null) {                   // 1、node是根
                root = replacementNode;
            }else if(node == node.parent.left) {        // 2、node是父节点的左节点
                node.parent.left = replacementNode;
            }else {                                     // 3、node是父节点的有右节点
                node.parent.right = replacementNode;
            }
        }else {                                         // node度为0，直接删除
            if(node.parent == null) {                   // 1、node是root
                root = null;
                return;
            }
            if(node == node.parent.left) node.parent.left = null;   // 2、node是左节点
            if(node == node.parent.right) node.parent.right = null; // 3、node是右节点
        }
    }

    /**
     * 二叉搜索树-根据元素找到节点
     * @param element
     * @return
     */
    public Node<E> node(E element){
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp > 0) node = node.right;
            if (cmp < 0) node = node.left;
            if (cmp == 0) return node;
        }
        return null;
    }

    /**
     * 可以定义一个接口，存放的数据都必须实现该接口的比较方法
     * @param e1
     * @param e2
     * @return
     * 返回值等于0，代表e1和e2相等
     * 返回值大于0，代表e1大于e2
     * 返回值小于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        //第一种方法
        //return e1.compareTo(e2);

        //第二种方法
        //return comparator.compare(e1, e2);

        //优化（如果传递比较器则使用比较器，如果没有传递则要求存放的数据实现Comparable接口）
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }

        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
}
