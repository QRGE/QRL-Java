package qr.Java.LeetCode.HouseRobber.HouseRobber_198;

// https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
// 刚练习dp, 只能参考官方题解做题

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);

        // 稍微有点理解了, 每步都取最高值
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
