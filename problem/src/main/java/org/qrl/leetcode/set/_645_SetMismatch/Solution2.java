package org.qrl.leetcode.set._645_SetMismatch;

import java.util.HashMap;
import java.util.Map;

/**
 * 看题解后用hashMap进行优化, 记录每个数字出现的次数, 出现两次的数字即为重复的数字, 出现一次的数字即为丢失的数字
 * @Author: QR
 * @Date: 2021/7/22-10:27
 */
@SuppressWarnings("ALL")
public class Solution2 {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                result[0] = i;
            } else if (count == 0) {
                result[1] = i;
            }
        }
        return result;
    }
}
