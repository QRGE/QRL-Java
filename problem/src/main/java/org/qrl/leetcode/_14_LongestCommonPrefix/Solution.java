package org.qrl.leetcode._14_LongestCommonPrefix;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author QR
 */
public class Solution {

    /**
     * 看官网的题解思路写的,一开始想的是找到最短的字符串后再逐个字符截取遍历所有的字符串进行查找
     * @param strs 待查询公共前缀字符串的数组
     * @return 最大公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 在每两个公共前缀之间获得最短的公共前缀
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str = findCommonPrefix(str, strs[i]);
            if ("".equals(str)){
                break;
            }
        }
        return str;
    }

    public String findCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int result = 0;
        while (result < length && str1.charAt(result) == str2.charAt(result)){
            result ++;
        }
        return str1.substring(0, result);
    }
}
