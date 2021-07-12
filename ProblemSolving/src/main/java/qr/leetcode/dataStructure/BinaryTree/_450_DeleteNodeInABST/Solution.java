package qr.leetcode.dataStructure.BinaryTree._450_DeleteNodeInABST;

import qr.leetcode.dataStructure.BinaryTree.TreeNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 参考题解写的, 一开始还不明白为什么返回的是root, 没看清题意
 * @Author: QR
 * @Date: 2021/7/8-16:56
 */
public class Solution {

    /**
     * 查找BST的后继节点值
     * @param node 待查找BST
     * @return 后继节点值
     */
    public int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    /**
     * 查找BST的前驱节点值
     * @param root 待查找的BST
     * @return 前驱节点的值
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // key == root.val
        else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                // 将待删除节点值替换到其后继节点值后再删除后继节点
                root.val = successor(root);
                // root.right!=null 且赋值为原来root.right删除后继节点后的值
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
