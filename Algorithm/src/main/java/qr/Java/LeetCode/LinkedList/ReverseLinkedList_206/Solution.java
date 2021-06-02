package qr.Java.LeetCode.LinkedList.ReverseLinkedList_206;

import qr.Java.LeetCode.LinkedList.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;  // 空节点直接返回null
        if (head.next == null) return head; // 只有一个节点直接返回head

        /*
        如示例 1 -> 2 -> 3 -> 4 -> 5 -> null
        每一次reverseList()把两个节点顺序替换,如第一次reverseList(head.next) 1.next.next 即3 指向了
         */
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head){
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode newHead = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
