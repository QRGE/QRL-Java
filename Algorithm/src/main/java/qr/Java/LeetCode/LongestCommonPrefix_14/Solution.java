package qr.Java.LeetCode.LongestCommonPrefix_14;

// https://leetcode-cn.com/problems/longest-common-prefix/

public class Solution {
    // 看官网的题解思路写的,一开始想的是找到最短的字符串后再逐个字符截取遍历所有的字符串进行查找
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";


        // 找到所有字符串之间的最长共公共前缀
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str = findLongestCommonPrefix(str, strs[i]);
            if (str.equals("")){
                break;
            }
        }
        return str;
    }

    // 找到两个字符串之间的最长公共前缀
    public static String findLongestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int result = 0;
        while (result < length && str1.charAt(result) == str2.charAt(result)){
            result ++;
        }
        return str1.substring(0, result);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
