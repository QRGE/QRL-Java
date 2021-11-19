package org.qrl.leetcode.binaryTree._104_MaximumDepthOfBinaryTree;

import org.qrl.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Author: QR
 * @Date: 2021/7/8-10:41
 */
public class Solution {

    /**
     * 迭代计算某个二叉树的深度
     * @param node 待计算深度的二叉树
     * @return 二叉树深度值
     */
    public int maxDepth1(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int deep = 0;
        // 每层的节点数, 根节点则为1
        int levelSize = 1;
        // 利用队列存储每层的节点
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(node);
        // 取每层的每个节点都对其进行判断是否有左右节点, 取完后如果队列为空则表示已经到底
        // 如果 !levelNodes.isEmpty()&&levelSize==0 时说明该层节点已经取完, 层数加一继续
        while(!levelNodes.isEmpty()){
            node = levelNodes.poll();
            levelSize--;
            if(node.left != null) {
                levelNodes.offer(node.left);
            }
            if(node.right != null) {
                levelNodes.offer(node.right);
            }
            if(levelSize == 0) {
                deep++;
                levelSize = levelNodes.size();
            }
        }
        return deep;
    }

    /**
     * 利用递归计算二叉树深度值
     * @param node 待计算深度的二叉树
     * @return 二叉树深度值
     */
    public int maxDepth2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth2(node.left), maxDepth2(node.right));
    }
}
