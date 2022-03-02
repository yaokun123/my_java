package com.dataStructure.a_leetcode_00.树;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author yaokun
 *
 */
public class _94_二叉树的中序遍历 {
	
	
	//1、递归实现
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		
		inorder(root,res);
		return res;
    }
	
	public void inorder(TreeNode node,List<Integer> l) {
		if (node == null) return;
		
		inorder(node.left,l);
		l.add(node.val);
		inorder(node.right,l);
		
	}
	
	
	//2、遍历实现
}
