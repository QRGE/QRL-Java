package qr.leetcode.binaryTree._101_SymmetricTree;

import qr.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: QR
 * @Date: 2021/7/21-2:13
 */
@SuppressWarnings("all")
public class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }
            // 左子树的右子树要和右子树的左子树值相等
            queue.offer(left.left);
            queue.offer(right.right);
            // 左子树的左子树要和右子树的右子树值相等
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
