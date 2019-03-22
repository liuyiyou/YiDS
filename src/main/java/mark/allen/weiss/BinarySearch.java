package mark.allen.weiss;


/**
 * @author: liuyiyou.cn
 * @date: 2019/2/12
 * @version: V1.0
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 13};
        int index = binarySearch(a, 5);
        System.out.println(index);
    }

    public static int binarySearch(int[] a, int item) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            //选取中间点，为什么不使用 a.length/2,1： 数组长度不变，导致中间点不会变
            int mid = (high + low) / 2;
            // 如果中间点和所给数据相等，则返回
            if (a[mid] == item) {
                return mid;
            } else if (a[mid] > item) {
                // 如果中间点的数据>查询数据，说明查询的数据在中间点的左边。
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
