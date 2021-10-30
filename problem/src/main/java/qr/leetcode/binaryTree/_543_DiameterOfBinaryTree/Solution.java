package qr.leetcode.binaryTree._543_DiameterOfBinaryTree;

import qr.leetcode.binaryTree.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @Author: QR
 * @Date: 2021/7/26-0:04
 */
@SuppressWarnings("all")
public class Solution {

    int maxd=0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        maxd=Math.max(Left+Right,maxd);
        //返回节点深度
        return Math.max(Left,Right)+1;
    }
}
