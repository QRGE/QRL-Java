package qr.Java.DataStructure.List.LinkedList;

import java.util.Arrays;

/**
 * 静态链表, 对于一些没有指针的编程语言, 例如早期的BASIC, FORTRAN等
 * 利用数组模拟链表, 称为静态链表
 * 数组中每个元素存放2个数据, 值/下一个数据的索引
 * 数组0索引处为存放头结点的位置
 */
public class StaticList {
    public static void main(String[] args) {
        int[][] staticList = new int[5][2];
        staticList[0] = new int[]{11, 3};
        staticList[1] = new int[]{22, 4};
        staticList[2] = new int[]{33, -1};  // -1表示单向链表的结尾
        staticList[3] = new int[]{44, 1};
        staticList[4] = new int[]{55, 2};
        for (int[] ints : staticList) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
