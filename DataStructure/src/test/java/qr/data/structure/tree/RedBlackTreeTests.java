package qr.data.structure.tree;

import org.junit.Test;
import qr.data.structure.tree.printer.BinaryTrees;

/**
 * @Author: QR
 * @Date: 2021/7/17-13:36
 */
public class RedBlackTreeTests {

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

    @Test
    public void removeTest(){
        Integer[] nums = new Integer[] {
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();
        for (Integer num : nums) {
            rbTree.add(num);
        }
        BinaryTrees.println(rbTree);
        for (Integer num : nums) {
            System.out.println("remove: " + num);
            rbTree.remove(num);
            BinaryTrees.println(rbTree);
        }
    }
}
