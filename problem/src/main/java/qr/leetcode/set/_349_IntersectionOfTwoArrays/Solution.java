package qr.leetcode.set._349_IntersectionOfTwoArrays;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @Author: QR
 * @Date: 2021/7/19-15:59
 */
@SuppressWarnings("unused")
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        return getIntersection(set1, set2);
    }

    private int[] getIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        if (set1.size() > set2.size()){
            return getIntersection(set2, set1);
        }
        HashSet<Integer> interSectionSet = new HashSet<>();
        // 获取交集部分
        for (Integer i : set1) {
            if (set2.contains(i)){
                interSectionSet.add(i);
            }
        }
        int[] intersection = new int[interSectionSet.size()];
        int index = 0;
        for (Integer i : interSectionSet) {
            intersection[index++] = i;
        }
        return intersection;
    }
}
