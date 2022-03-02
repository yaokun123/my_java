package com.dataStructure.a_leetcode_00.树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author yaokun
 *
 */
public class _145_二叉树的后序遍历 {
	
	//1、递归实现
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		
		postorder(root,res);
		return res;
    }
	
	public void postorder(TreeNode node,List<Integer> l) {
		if (node == null) return;
		
		postorder(node.left,l);
		postorder(node.right,l);
		l.add(node.val);
		
	}
	
	
	//2、遍历实现
}
