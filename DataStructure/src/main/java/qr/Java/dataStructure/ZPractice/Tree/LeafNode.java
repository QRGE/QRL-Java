package qr.Java.dataStructure.ZPractice.Tree;

/**
 * 设一颗完全二叉树的有768个节点, 求叶子节点的个数 <br/>
 * 假设叶子节点个数为n0, 度为1的节点个数为n1, 度为2的节点个数为n2 <br/>
 * 则有总结节点个数n = n0 + n1 + n2, 结合 n0 = n2 + 1 可推出 n = 2n0 + n1 - 1 <br/>
 * 由于完全二叉树的n1值不是0就是1, 且n1是整数, 则有: <br/>
 * - n为偶数 时, n1 = 1, n0 = n / 2 <br/>
 * - n为奇数 时, n1 = 0, n0 = (n+1) / 2 <br/>
 * 总结:
 * 叶子节点个数:
 * - n0=floor((n + 1) / 2) <br/>
 * - 非叶子节点个数: n1 + n2 = floor(n / 2) <br/>
 * @Author: QR
 * @Date: 2021/7/4-17:05
 */
public class LeafNode {

}
