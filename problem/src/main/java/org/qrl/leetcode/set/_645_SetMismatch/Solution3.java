package org.qrl.leetcode.set._645_SetMismatch;

/**
 * 数学方法: 假设 1 到 n 之和位s1, nums 之和为 s2, nums去重后之和为 s3
 *      重复的数: s3 - s2
 *      缺失的数: s1 - s2
 * @Author: QR
 * @Date: 2021/7/22-10:47
 */
@SuppressWarnings("ALL")
public class Solution3 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] cnts = new int[n + 1];
        // 1 到 n 之和
        int tot = (1 + n) * n / 2;
        int sum = 0, set = 0;
        for (int x : nums) {
            sum += x;
            if (cnts[x] == 0) set += x;
            cnts[x] = 1;
        }
        return new int[]{sum - set, tot - set};
    }
}
