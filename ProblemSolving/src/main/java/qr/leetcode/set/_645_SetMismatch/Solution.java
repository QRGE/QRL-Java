package qr.leetcode.set._645_SetMismatch;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/set-mismatch/
 * 某个数字复制成了集合的另一个数字值, 导致一个 丢失了一个数字 且有一个数字重复
 * @Author: QR
 * @Date: 2021/7/22-9:42
 */
@SuppressWarnings("all")
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                result[0] = nums[i];
            }
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i+1)){
                result[1] = nums[i];
            }
        }
        return result;
    }
}
