package org.qrl.leetcode.list._237_DeleteNodeInALinkedList;


import org.qrl.leetcode.list.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val; // 把node的节点的数据换成node.next节点的数据
        node.next = node.next.next; // node.next指向node.next.next
        /*
         *  如示例1: head = [4,5,1,9], node = 5
         *  5处的值编程1,然后5.next指向了9的节点,从而实现删除5的节点的效果
         */
    }
}

