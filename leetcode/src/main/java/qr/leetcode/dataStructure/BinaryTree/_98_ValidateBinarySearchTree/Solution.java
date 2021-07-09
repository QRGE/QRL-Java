package qr.leetcode.dataStructure.BinaryTree._98_ValidateBinarySearchTree;

import qr.leetcode.dataStructure.BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @Author: QR
 * @Date: 2021/7/8-17:24
 */
public class Solution {
    public boolean isValidBinarySearchTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        boolean flag = true;
        TreeNode node;
        while (!nodes.isEmpty()){
            node = nodes.poll();
            if (node.left != null) {
                if (node.left.val >= node.val) {
                    flag = false;
                    break;
                }
                nodes.offer(node.left);
            }
            if (node.right != null) {
                if (node.right.val <= node.val){
                    flag = false;
                    break;
                }
                nodes.offer(node.right);
            }
        }
        return flag;
    }

    /**
     * 利用中序遍历判断一个树是否为BST
     * @param root 待判断的二叉树
     * @return 返回的结果
     */
    public boolean isValidBinarySearchTree2(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        // 需要足够小, 测试用例中有个为-Integer.MAX_VALUE
        double flag = -Double.MAX_VALUE;
        // 利用栈中序遍历二叉树
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果遍历得到的节点的值小于等于前一个 flag, 说明不符合BST规律
            if (root.val <= flag) {
                return false;
            }
            flag = root.val;
            root = root.right;
        }
        return true;
    }

}
