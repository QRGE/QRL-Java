package qr.leetcode.binaryTree._863_AllNodesDistanceKInBinaryTree;

import qr.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * @Author: QR
 * @Date: 2021/7/28-13:14
 */
@SuppressWarnings("unused")
public class Solution {

    private final List<Integer> result = new ArrayList<>();

    /**
     *
     * @param root 根节点
     * @param target 目标节点
     * @param k 和目标节点的距离 k
     * @return 目标节点的距离 k 的节点值集合
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null || target == null) {
            return result;
        }
        if (root.val == target.val){
            childDistanceK(root, k);
            return result;
        }
        return null;
    }

    /**
     * 如果 target 是 root 一边的子节点, 则需要找到在root另一边中距离target为k的节点
     * @param k 距离k
     */
    private void sizeDistanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int rootToTarget = 0;
        int queueSize = 1;
        TreeNode n;
        while (!queue.isEmpty()){
            queueSize--;
            n = queue.poll();
            if (n.val == target.val){
                break;
            }
            if (n.left != null){
                queue.offer(n.left);
            }
            if (n.right != null){
                queue.offer(n.right);
            }
            if (queueSize == 0){
                queueSize = queue.size();
                rootToTarget++;
            }
        }
    }

    /**
     * 利用层序遍历寻找 node 距离为 k 的子节点, 其实就是找层数为 k 的节点
     * @param node node
     * @param k 距离 k
     */
    private void childDistanceK(TreeNode node, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int distance = 0;
        int queueSize = 1;
        TreeNode n;
        while (!queue.isEmpty()){
            n = queue.poll();
            queueSize--;
            if (distance == k) {
                break;
            }
            if (n.left != null){
                queue.offer(n.left);
            }
            if (n.right != null){
                queue.offer(n.right);
            }
            if (queueSize == 0){
                queueSize = queue.size();
                distance++;
            }
        }
        // 如果 target 的层数没有到达 k 说明其子节点没有距离其为 k 的节点, 例如 k=2, 而node的层数只有1
        if (distance == k) {
            for (TreeNode treeNode : queue) {
                result.add(treeNode.val);
            }
        }
    }
}
