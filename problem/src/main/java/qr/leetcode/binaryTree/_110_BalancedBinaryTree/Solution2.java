package qr.leetcode.binaryTree._110_BalancedBinaryTree;

import qr.leetcode.binaryTree.TreeNode;

/**
 * 自顶向下的递归求解发
 * @Author: QR
 * @Date: 2021/7/21-1:44
 */
@SuppressWarnings("all")
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
