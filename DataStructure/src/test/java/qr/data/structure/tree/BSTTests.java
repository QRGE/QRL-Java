package qr.data.structure.tree;

import org.junit.jupiter.api.Test;
import qr.data.structure.domain.Person;
import qr.data.structure.domain.PersonComparator;
import qr.data.structure.tree.printer.BinaryTrees;

/**
 * BST的一些测试
 * @Author: QR
 * @Date: 2021/7/5-15:58
 */
public class BSTTests {

    private final static BinarySearchTree<Integer> numTree = new BinarySearchTree<>();

    static {
        Integer[] nums = new Integer[] {
                17, 6, 8, 9, 11, 25, 9, 7, 5, 2, 1, 3, 65, 57, 84
        };
        for (Integer num : nums) {
            numTree.add(num);
        }
    }

    @Test
    public void removeTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] nums = new Integer[] {
                17, 6, 8, 9, 11, 25, 9, 7, 5, 2, 1, 3, 65, 57
        };
        for (Integer num : nums) {
            bst.add(num);
        }
        BinaryTrees.println(bst);
        bst.remove(3);
        bst.remove(11);
        BinaryTrees.println(bst);
        bst.remove(5);
        BinaryTrees.println(bst);
        bst.remove(6);
        BinaryTrees.println(bst);
    }

    @Test
    public void BSTPreTravelTest(){
        BinaryTrees.println(numTree);
        numTree.preorderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element != 5;
            }
        });
    }

    @Test
    public void BSTInorderTraversalTest(){
        BinaryTrees.println(numTree);
        numTree.inorderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element != 5;
            }
        });
    }

    @Test
    public void BSTPostOrderTraversalTest(){
        BinaryTrees.println(numTree);
        numTree.postorderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element != 5;
            }
        });
    }

    @Test
    public void BSTLevelOrderTraversalTest(){
        BinaryTrees.println(numTree);
        numTree.levelOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            protected boolean visit(Integer element) {
                System.out.print(element + " ");
                return element != 7;
            }
        });
    }

    @Test
    public void BSTAddPersonTest(){
        Person[] persons = new Person[] {
                new Person(1, 12, "toolMan1"), new Person(1, 5, "toolMan7"), new Person(1, 17, "toolMan2"),
                new Person(1, 19, "toolMan3"), new Person(1, 21, "toolMan4"), new Person(1, 11, "toolMan5"),
                new Person(1, 32, "toolMan6")
        };
        BinarySearchTree<Person> personBST = new BinarySearchTree<>(new PersonComparator());
        for (Person person : persons) {
            personBST.add(person);
        }
        BinaryTrees.print(personBST);
    }

    @Test
    public void BSTHeightTest(){
        BinaryTrees.println(numTree);
        System.out.println(numTree.height());
    }

    @Test
    public void BSTtoStringTest(){
        System.out.println(numTree);
    }
}
