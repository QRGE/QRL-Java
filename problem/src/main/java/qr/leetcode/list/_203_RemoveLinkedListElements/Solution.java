package qr.leetcode.list._203_RemoveLinkedListElements;

// https://leetcode-cn.com/problems/remove-linked-list-elements/

import qr.leetcode.list.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 按照题解思路先创建一个哨兵节点(我就叫工具人节点吧)
        /*ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;*/
        if(head==null) return null;
        ListNode newNode=new ListNode(0);
        newNode.next=head;
        ListNode p=newNode;
        while(newNode.next!=null){
            if(newNode.next.val==val) newNode.next=newNode.next.next;
            else newNode=newNode.next;
        }
        return p.next;
    }
}
