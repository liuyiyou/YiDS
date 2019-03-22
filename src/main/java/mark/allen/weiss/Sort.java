package mark.allen.weiss;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/12
 * @version: V1.0
 */
public class Sort {


    public static void main(String[] args) {
        int[] a = {3, 4, 6, 8, 7, 12, 5, 1};
        int[] a2 = {3, 4, 6, 8, 7, 12, 5, 1};
//        print(a);
//        System.out.println(findMin(a));
//        System.out.println(findMinIndex(a));
//        swap(a,0,7);
//        print(a);
        print(a);
        selectSort(a);
        print(a);

        System.out.println("'======================='");
        print(a2);
        selectSort2(a2);
        print(a2);
    }

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = findMinIndex(a, i);
            //System.out.println("aaa::" + minIndex);
            swap(a, minIndex, i);
            print(a);
        }


    }

    public static void selectSort2(int[] a) {
        int minIndex = 0;
        int temp = 0;
        if ((a == null) || (a.length == 0))
            return;
        for (int i = 0; i < a.length; i++) {
            minIndex = i;//无序区的最小数据数组下标
            for (int j = i + 1; j < a.length; j++) {
                //在无序区中找到最小数据并保存其数组下标
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //将最小元素放到本次循环的前端
            temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;

            print(a);
        }
    }

    public static void swap(int[] a, int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }


    public static int findMin(int[] a, int index) {
        int min = a[0];
        int minIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                minIndex = i;
            }
        }
        return min;
    }

    public static int findMinIndex(int[] a, int index) {
        int min = a[index];
        int minIndex = index;
        for (int i = index; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }
}
