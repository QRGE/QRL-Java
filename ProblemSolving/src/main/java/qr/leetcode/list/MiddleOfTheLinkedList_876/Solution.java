package qr.leetcode.list.MiddleOfTheLinkedList_876;

// https://leetcode-cn.com/problems/middle-of-the-linked-list/

import qr.leetcode.list.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;
        // 首先题目说了是非空链表,故链表的元素最少都有一个,而且下面的循环似乎没有计算到最后一个节点的个数
        int size = 1;
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            size++;
        }

        ListNode result;
        for (int i = 0; i < size/2; i++) {
            head = head.next;
        }
        result = head;
        return result;
    }

    // 从题解看到的快慢指针的思路,真滴牛啊
    public ListNode middleNode2(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
