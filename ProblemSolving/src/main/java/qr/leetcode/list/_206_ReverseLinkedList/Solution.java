package qr.leetcode.list._206_ReverseLinkedList;

import qr.leetcode.list.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author QR
 */
public class Solution {

    public ListNode reverseListByRecursion(ListNode head) {
        // 空节点直接返回null
        if (head == null) {
            return null;
        }
        // 只有一个节点直接返回head
        if (head.next == null) {
            return head;
        }

        /*
        如示例 1 -> 2 -> 3 -> 4 -> 5 -> null
        每一次reverseList()把两个节点顺序替换,如第一次reverseList(head.next) 1.next.next 即3 指向了
         */
        ListNode newHead = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseListByIteration(ListNode head){
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode temp;
        while (head != null){
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
