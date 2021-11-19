package org.qrl.leetcode.binaryTree._700_SearchInABinarySearchTree;

import org.qrl.leetcode.binaryTree.TreeNode;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/submissions/
 * @Author: QR
 * @Date: 2021/7/8-17:00
 */

public class Solution {
    public TreeNode search(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        while (node.val != val){
            if (val < node.val && node.left != null) {
                node = node.left;
            }
            else if (val > node.val && node.right != null){
                node = node.right;
            }
            // 没找到
            else {
                return null;
            }
        }
        return node;
    }
}
