package qr.algorithm.primary.array.delete_duplicates_from_sorted_data;

/**
 * @Author: QR
 * @Date: 2021/9/10-18:08
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]){
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }
}
