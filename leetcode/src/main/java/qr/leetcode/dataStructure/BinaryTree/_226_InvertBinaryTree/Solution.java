package qr.leetcode.dataStructure.BinaryTree._226_InvertBinaryTree;

import qr.leetcode.dataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @Author: QR
 * @Date: 2021/7/8-12:08
 */

@SuppressWarnings("UnusedReturnValue")
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换节点
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 用层序遍历BinaryTree中的每个节点再进行左右节点的交换
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(node);
        TreeNode n;
        while (!nodes.isEmpty()) {
            n = nodes.poll();
            TreeNode temp = n.right;
            n.right = n.left;
            n.left = temp;

            if (n.left != null) {
                nodes.offer(n.left);
            }
            if (n.right != null) {
                nodes.offer(n.right);
            }
        }
        return node;
    }
}
