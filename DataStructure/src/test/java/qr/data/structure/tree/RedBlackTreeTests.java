package qr.data.structure.tree;

import org.junit.Test;
import qr.data.structure.tree.printer.BinaryTrees;

/**
 * @Author: QR
 * @Date: 2021/7/17-13:36
 */
public class RedBlackTreeTests {

    private final static RedBlackTree<Integer> rbt_nums = new RedBlackTree<>();
    private final static Integer[] nums = new Integer[] {
            85, 19, 69, 3, 7, 99, 95, 2, 1, 77, 51, 58, 11, 21, 15, 93, 57, 22, 2, 66
    };

    static {
        for (Integer num : nums) {
            rbt_nums.add(num);
        }
    }

    @Test
    public void addTest(){
        Integer[] nums = new Integer[] {
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();
        for (Integer num : nums) {
            rbTree.add(num);
        }
        BinaryTrees.println(rbTree);
    }
}
