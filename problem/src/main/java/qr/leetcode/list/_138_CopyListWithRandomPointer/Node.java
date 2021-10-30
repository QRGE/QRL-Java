package qr.leetcode.list._138_CopyListWithRandomPointer;

/**
 * @Author: QR
 * @Date: 2021/7/22-9:20
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
