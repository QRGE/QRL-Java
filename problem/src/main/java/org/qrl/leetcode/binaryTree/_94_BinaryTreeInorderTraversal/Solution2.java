package org.qrl.leetcode.binaryTree._94_BinaryTreeInorderTraversal;

import org.qrl.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 利用栈实现中序遍历
 * @Author: QR
 * @Date: 2021/7/22-0:31
 */
@SuppressWarnings("all")
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 注意这里是 ||
        while (root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
