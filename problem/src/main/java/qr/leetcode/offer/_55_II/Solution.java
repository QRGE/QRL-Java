package qr.leetcode.offer._55_II;

import qr.leetcode.binaryTree.TreeNode;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @Author: QR
 * @Date: 2021/7/26-0:39
 */
@SuppressWarnings("all")
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1  && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
