package qr.leetcode.offer._28_;

import qr.leetcode.binaryTree.TreeNode;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @Author: QR
 * @Date: 2021/7/28-13:04
 */
@SuppressWarnings("unused, UnusedReturnValue")
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
