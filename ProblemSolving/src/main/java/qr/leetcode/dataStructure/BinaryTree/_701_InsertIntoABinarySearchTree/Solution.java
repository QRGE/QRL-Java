package qr.leetcode.dataStructure.BinaryTree._701_InsertIntoABinarySearchTree;

import qr.leetcode.dataStructure.BinaryTree.TreeNode;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * @Author: QR
 * @Date: 2021/7/9-16:48
 */
public class Solution {

    public TreeNode insertIntoBinarySearchTree(TreeNode root, int val) {
        return insertByIteration(root, val);
    }

    private TreeNode insertByRecursion(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val){
            root.right = insertByRecursion(root.right, val);
        }else {
            root.left = insertByRecursion(root.left, val);
        }
        return root;
    }

    private TreeNode insertByIteration(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (true) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                }else {
                    node = node.left;
                }
            }
            // val > node.val
            else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                }else {
                    node = node.right;
                }
            }
        }
        return root;
    }

}
