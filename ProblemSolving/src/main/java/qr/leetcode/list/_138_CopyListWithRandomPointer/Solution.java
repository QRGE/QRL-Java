package qr.leetcode.list._138_CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: QR
 * @Date: 2021/7/22-9:17
 */
@SuppressWarnings("all")
public class Solution {

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node newHead = new Node(head.val);
            cachedNode.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
