package qr.algorithm.primary.string.replace;

/**
 * 例如替换字符串中的所有 空格 为 %20
 * @Author: QR
 * @Date: 2021/9/11-10:04
 */
public class Solution {

    /**
     * 例如替换字符串中的所有 空格 为 %20
     * @param oldStr 传入的字符串
     * @return 新的字符串
     */
    public static String replaceSpace(String oldStr){
        // 有效参数判断
        if (oldStr == null || oldStr.equals("")) return "";
        char[] oldChars = oldStr.toCharArray();
        int i = 0;
        int lengthSpace = 0;
        // 计算空格的个数
        while (i < oldChars.length) {
            if (oldChars[i] == ' ') lengthSpace++;
            i++;
        }
        // 计算新的字符串的长度
        int newStrLength = oldStr.length() + lengthSpace * 2;
        char[] newChars = new char[newStrLength];
        int j = newStrLength - 1;
        i = oldChars.length - 1;
        while (i >= 0) {
            if (oldChars[i] != ' ') {
                newChars[j--] = oldChars[i--];
            }else {
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
                i--;
            }
        }
        return new String(newChars);
    }

    public static void main(String[] args) {
        String newString = replaceSpace("I am sad");
        System.out.println(newString);
    }
}
