package org.qrl.leetcode.offer._27_;

import org.qrl.leetcode.binaryTree.TreeNode;

/**
 * @Author: QR
 * @Date: 2021/7/28-14:00
 */

@SuppressWarnings("unused")
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
