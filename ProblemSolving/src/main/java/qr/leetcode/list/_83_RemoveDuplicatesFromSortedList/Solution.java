package qr.leetcode.list._83_RemoveDuplicatesFromSortedList;

import qr.leetcode.list.ListNode;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head; // 需要一个工具链表
        while (curr.next != null){
            // 删除重复元素的不用考虑首边界的问题,直接进行val的比较若相等则删除即可
            // 个人理解 删除指定元素的节点 需要用到哨兵节点是首边界的问题
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }
}
