package qr.leetcode.binaryTree._110_BalancedBinaryTree;

import qr.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求出左右子树的高度再进行相减进行判断
 * @Author: QR
 * @Date: 2021/7/21-1:04
 */
@SuppressWarnings("all")
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int height = height(root.left) - height(root.right);
        return Math.abs(height) <= 1;
    }

    public int height(TreeNode node){
        if (node == null){
            return 0;
        }
        int height = 0;
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int size = 1;
        while (!queue.isEmpty()){
            temp = queue.poll(); size--;
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right!= null){
                queue.offer(temp.right);
            }
            if (size == 0){
                size = queue.size();
                height++;
            }
        }
        return height;
    }
}
