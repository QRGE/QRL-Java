package qr.leetcode.RabbitsInForest_781;

// https://leetcode-cn.com/problems/rabbits-in-forest/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 假设有n只兔子说与它们有相同颜色的兔子的个数为m, 则认定它们的颜色相同且该种兔子的数量为m+1
public class Solution {
    public int numRabbits(int[] answers) {
        if (answers.length == 0) return 0;
        Map<Integer, Integer> count = new HashMap<>();                  // count用来存储每种颜色兔子的个数
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);                 // getOrDefault(y, 0), 如果有key=y则获取y的value, 如果没有则设置为0
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }

    // (｀・ω・´)这种想法和我最初的想法类似
    public int numRabbits2(int[] answers) {
        Arrays.sort(answers);           // 进行排序, 让回答相同数量的🐇尽量分成一组
        int ans = 0;                    // 记录最少🐇的个数
        for (int i = 0; i < answers.length; i++) {
            int cnt = answers[i];
            ans += cnt + 1;
            // 跳过「数值 cnt」后面的 cnt 个「数值 cnt」
            int k = cnt;
            while (k-- > 0 && i + 1 < answers.length && answers[i] == answers[i + 1]) i++;
        }
        return ans;
    }
}
