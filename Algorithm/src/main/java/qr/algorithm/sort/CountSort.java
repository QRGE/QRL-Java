package qr.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序适合对正数排序
 * @Author qr
 * @Date 2022/5/4-01:44
 */
public class CountSort{

    public static void main(String[] args) {
        int[] nums = {2,4,1,2,5,3,4,8,7};
        new CountSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] arr) {
        if (arr.length < 1) return;
        // 序列中最大的数
        int max = arr[0];
        for (int i : arr)
            if (i > max) max = i;
        // 创建计数数组, 并对 arr 进行计数
        int[] countArr = new int[max+1];
        for (int i : arr)
            countArr[i]++;
        // 统计计数数组的累计值
        for (int i = 1; i < countArr.length; i++)
            countArr[i] += countArr[i-1];
        // 进行排序
        int[] temp = new int[arr.length];
        for (int i : arr) {
            int index = countArr[i]--;
            temp[index-1] = i;
        }
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }
}
