package org.qrl.leetcode.binaryTree._94_BinaryTreeInorderTraversal;

import org.qrl.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用递归实现中序遍历
 * @Author: QR
 * @Date: 2021/7/22-0:16
 */
@SuppressWarnings("all")
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, ArrayList<Integer> result) {
        if (node == null){
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
