package org.qrl.leetcode.list._141_LinkedListCycle;

// https://leetcode-cn.com/problems/linked-list-cycle/

import org.qrl.leetcode.list.ListNode;

public class Solution {
    // 快慢指针思路 O(n)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false; // head == null 条件也要添加,检测条件里还真他妈的有
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
