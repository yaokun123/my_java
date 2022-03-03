package com.dataStructure.g_二叉搜索树_06;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 二叉搜索树判断元素是否存在
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return node(element) != null;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 二叉树-前序遍历
     * 先遍历根节点，再遍历左节点，再遍历右节点
     */
    public void preorderTraversal(){
        preorderTraversal(root);
    }
    public void preorderTraversal(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);

        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }


    /**
     * 二叉树-后序遍历
     * 先遍历左节点，再遍历右节点，再遍历根节点
     */
    public void postorderTraversal() {
        postorderTraversal(root);
    }
    public void postorderTraversal(Node<E> node) {
        if (node == null) return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);
    }

    /**
     * 二叉树中序遍历
     * 先遍历左节点，再遍历跟节点，再遍历右节点
     */
    public void inorderTraversal() {
        inorderTraversal(root);
    }
    public void inorderTraversal(Node<E> node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    /**
     * 二叉树层序遍历
     */
    public void levelOrderTraversal() {
        if (root == null) return;

        //使用队列
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);                                  // 根节点入队

        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.poll();             // 出队
            System.out.println(currentNode.element);

            if (currentNode.left != null) {                 // 左节点入队
                queue.offer(currentNode.left);
            }

            if(currentNode.right != null) {                 // 右节点入队
                queue.offer(currentNode.right);
            }

        }
    }

    /**
     * 二叉树-计算高度（递归）
     * @return
     */
    public int height() {
        return height(root);
    }
    public int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 二叉树-计算高度（层序遍历）
     * @return
     */
    public int height2() {
        if (root == null) return 0;

        //使用队列
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);//根节点入队

        int height = 0;
        int levelSize = 1;

        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.poll();
            levelSize--;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if(levelSize == 0) {//即将要访问下一层
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 判断一棵树是否为完全二叉树（层序遍历）
     * @return
     */
    public boolean isComplete() {
        if (root == null) return false;

        /**
         * 思路：
         * 如果node.left != null && node.right != null ，将node.left、node.right按顺序入队
         *
         * 如果node.left == null && node.right != null ，返回false
         *
         * 如果node.left != null && node.right == null
         * 或者node.left == null && node.right == null
         * 那么后面的遍历的节点都为叶子节点，才是完全二叉树
         */

        //使用队列
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);//根节点入队
        boolean leaf = false;//标识是否从该节点之后都要是叶子节点

        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.poll();
            if(leaf) {
                if(currentNode.left != null || currentNode.right != null) {
                    return false;
                }
            }

            if (currentNode.left != null && currentNode.right != null) {//左右节点都不为空
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }else if(currentNode.left == null && currentNode.right != null) {//左节点为空、右节点不为空
                return false;
            }else {//左右节点都为空 + 左节点不为空右节点为空（后面遍历的节点都应该是叶子节点）
                leaf = true;
                if(currentNode.left != null) {//如果是左节点不为空右节点为空的情况左节点还要正常入队
                    queue.offer(currentNode.left);
                }
            }
        }
        return true;
    }

    /**
     * 二叉树-前驱节点
     * 按照中序遍历得到节点的前一个节点
     * @param node
     * @return
     */
    public Node<E> predecessor(Node<E> node){
        if (node == null) return null;

        if(node.left != null) {//如果左节点存在，就从左节点开始找，找到最右节点
            Node<E> tmpNode = node.left;
            while (node.right != null) {
                tmpNode = node.right;
            }
            return tmpNode;
        }else {
            //判断父节点是否为空
            while (node.parent != null && node.parent.left == node) {
                node = node.parent;
            }

            //node.parent == null || node = node.parent.right
            return node.parent;
        }
    }

    /**
     * 二叉树-后继节点
     * 按照中序遍历得到节点的后一个节点
     * @param node
     * @return
     */
    public Node<E> successor(Node<E> node){
        if (node == null) return null;

        if(node.right != null) {//如果右节点存在，就从右节点开始找，找到最左节点
            Node<E> tmpNode = node.right;
            while (node.left != null) {
                tmpNode = node.left;
            }
            return tmpNode;
        }else {
            //判断父节点是否为空
            while (node.parent != null && node.parent.right == node) {
                node = node.parent;
            }

            //node.parent == null || node = node.parent.right
            return node.parent;
        }
    }
}
