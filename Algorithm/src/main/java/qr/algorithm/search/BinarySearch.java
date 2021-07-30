package qr.algorithm.search;

/**
 * @Author: QR
 * @Date: 2021/7/28-16:45
 */
@SuppressWarnings("unused")
public class BinarySearch {

    public static int indexOf(Integer[] array, int target){
        if (array == null || array.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = array.length;
        while (begin < end){
            int mid = (begin + end) >> 1;
            if (target < array[mid]){
                end = mid;
            }else if (target > array[mid]){
                begin = mid + 1;
            }else { // target = array[mid] 直接返回 mid
                return mid;
            }
        }
        // 没找到
        return -1;
    }
}
