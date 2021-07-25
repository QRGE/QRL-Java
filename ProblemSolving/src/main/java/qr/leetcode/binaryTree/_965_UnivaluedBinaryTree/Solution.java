package qr.leetcode.binaryTree._965_UnivaluedBinaryTree;

import qr.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: QR
 * @Date: 2021/7/21-23:53
 */
@SuppressWarnings("all")
public class Solution {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int rootValue = root.val;
        TreeNode node;
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.val != rootValue){
                return false;
            }
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return true;
    }
}
