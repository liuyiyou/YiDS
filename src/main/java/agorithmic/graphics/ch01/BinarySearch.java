package agorithmic.graphics.ch01;

/**
 * 二分查找：O(logn)
 *
 * @author: liuyiyou.cn
 * @date: 2019/6/27
 * @version: V1.0
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        //mid = 3/
        int index1 = binarySearch(arr, 3);
        int index2 = binarySearch(arr, 6);
        int index3 = binarySearch(arr, 9);

        System.out.println(index1 + "\t" + index2 + "\t" + index3);
    }

    /**
     * @param arr
     * @param target
     * @Note 1：主要是中间点的选取
     * 2：减半的时候，mid要重新计算
     * [1,2,3,4,5,6,7]
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("low:" + low + "\thigh:" + high + "\tmid:" + mid);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
