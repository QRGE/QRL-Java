package org.qrl.leetcode.no1_TwoSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
//        return traversal(nums, target);
        return dealWithHashMap(nums, target);
    }

    private int[] dealWithHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i) {
                return new int[]{i, map.get(another)};
            }
        }
        return new int[]{};
    }

    private int[] twoSum3(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果获取到之前元素需要的差值, 则这两个元素相加为 target
            Integer x = map.get(nums[i]);
            if(x != null) {
                return new int[]{x,i};
            } else {
                // 存下差值
                map.put(target-nums[i],i);
            }
        }
        return new int[]{};
    }

    private int[] traversal(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    private static final int[] nums = {3, 2, 4};
    private static final int target = 6;
    private static final int[] expect = {1, 2};

    @Test
    public void test(){
        Solution solution = new Solution();
        int[] result = solution.dealWithHashMap(nums, target);
        Assertions.assertEquals(Arrays.toString(result), Arrays.toString(expect));
    }
}
