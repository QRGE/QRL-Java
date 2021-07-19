package qr.leetcode.binaryTree._617_MergeTwoBinaryTrees;

import qr.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: QR
 * @Date: 2021/7/18-12:24
 */
@SuppressWarnings("unused")
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesByIteration(root1, root2);
    }

    private TreeNode mergeTreesByIteration(TreeNode root1, TreeNode root2){
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> nodes1 = new LinkedList<>();
        nodes1.offer(root1);
        Queue<TreeNode> nodes2 = new LinkedList<>();
        nodes2.offer(root2);
        Queue<TreeNode> nodes3 = new LinkedList<>();
        TreeNode target = new TreeNode(root1.val + root2.val);
        nodes3.offer(target);
        TreeNode n1;
        TreeNode n2;
        TreeNode n3;
        while (!nodes1.isEmpty() || !nodes2.isEmpty()){
            n1 = nodes1.poll();assert n1 != null;
            n2 = nodes2.poll();assert n2 != null;
            n3 = nodes3.poll();assert n3 != null;
            if (n1.left != null || n2.left != null){
                if (n1.left != null && n2.left != null){
                    n3.left = new TreeNode(n1.left.val + n2.left.val);
                    nodes1.offer(n1.left);
                    nodes2.offer(n2.left);
                    nodes3.offer(n3.left);
                }else if (n1.left != null){
                    n3.left = n1.left;
                }else {
                    n3.left = n2.left;
                }
            }
            if (n1.right != null || n2.right != null){
                if (n1.right != null && n2.right != null){
                    n3.right = new TreeNode(n1.right.val + n2.right.val);
                    nodes1.offer(n1.right);
                    nodes2.offer(n2.right);
                    nodes3.offer(n3.right);
                }else if (n1.right != null){
                    n3.right = n1.right;
                }else {
                    n3.right = n2.right;
                }
            }
        }
        return target;
    }

    private TreeNode mergeTreesByRecursion(TreeNode root1, TreeNode root2){
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode target = new TreeNode(root1.val + root2.val);
        target.left = mergeTreesByRecursion(root1.left, root2.left);
        target.right = mergeTreesByRecursion(root1.right, root2.right);
        return target;
    }
}
