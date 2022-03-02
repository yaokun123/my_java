package com.dataStructure.a_leetcode_00.链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curNode = head.next;
        ListNode preNode = head;

        while(curNode != null) {
            if(curNode.val == preNode.val) {
                //删除当前
                preNode.next = curNode.next;
                curNode = preNode.next;
            }else {
                preNode = curNode;
                curNode = curNode.next;
            }
        }

        return head;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        ListNode tmp = head;

        while(tmp != null && tmp.next != null){
            if(tmp.val == tmp.next.val){
                tmp.next = tmp.next.next;
            }else{
                tmp = tmp.next;
            }

        }
        return head;
    }
}
