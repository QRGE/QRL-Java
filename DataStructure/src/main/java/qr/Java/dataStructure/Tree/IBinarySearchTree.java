package qr.Java.dataStructure.Tree;

/**
 * Binary Search Tree: 二叉搜索树, 又称二叉查找树, 二叉排序树, 简称BST <br/>
 * BST特点: <br/>
 * - 任意一个节点的值都大于其左子树所有节点的值 <br/>
 * - 任意一个节点的值都小于其右子树所有节点的值 <br/>
 * - 它的左右子树页数一颗二叉搜索树
 * - BST的节点元素必须有可比较性, 且不允许为空 <br/>
 * @Author: QR
 * @Date: 2021/7/5-13:36
 */
public interface IBinarySearchTree<E> {

    /**
     * 返回元素节点个数
     * @return 节点个数
     */
    int size();

    /**
     * 判断BST是否为空
     * @return 判断结果
     */
    boolean isEmpty();

    /**
     * 添加元素到BST
     * @param element 待添加的元素
     */
    void add(E element);

    /**
     * 删除BST中的指定元素
     * @param element 待删除的元素
     */
    void remove(E element);

    /**
     * 判断BST中是否包含某元素
     * @param elements 待查询是否包含的元素
     * @return 返回查询的结果
     */
    boolean contains(E elements);

    /**
     * 清空BST
     */
    void clear();
}
