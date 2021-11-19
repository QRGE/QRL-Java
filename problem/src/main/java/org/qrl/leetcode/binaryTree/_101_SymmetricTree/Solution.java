package org.qrl.leetcode.binaryTree._101_SymmetricTree;

import org.qrl.leetcode.binaryTree.TreeNode;

/**
 * 递归条件:
 *      左子树l1和右子树r1的值相等
 *      l1的左子树和r1的右子树值相等
 *      l1的右子树和r1的左子树值相等
 * @Author: QR
 * @Date: 2021/7/21-1:50
 */
@SuppressWarnings("all")
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null){
            return true;
        }
        if (n1 == null || n2 == null){
            return false;
        }
        return (n1.val == n2.val) && (isMirror(n1.left, n2.right)) && (isMirror(n1.right, n2.left));
    }
}
