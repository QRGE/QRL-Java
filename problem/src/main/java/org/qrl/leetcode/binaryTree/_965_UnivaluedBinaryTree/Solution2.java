package org.qrl.leetcode.binaryTree._965_UnivaluedBinaryTree;

import org.qrl.leetcode.binaryTree.TreeNode;

/**
 * @Author: QR
 * @Date: 2021/7/22-0:01
 */
@SuppressWarnings("all")
public class Solution2 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left != null && root.left.val != root.val){
            return false;
        }
        if (root.right != null && root.right.val != root.val){
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
