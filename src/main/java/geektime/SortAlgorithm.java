package geektime;

public class SortAlgorithm {

    static int[] array = {1,2,1,3,1,1,1,1,6,8,8,9,9};

    public static void main(String[] args) {

//        insertSort(array);

        bubbleSort(array, array.length);
    }

    /**
     * 插入排序
     * @param array
     */
    private static void insertSort(int[] array){
        if (array == null || array.length < 2)
            return;

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int value = array[i];

            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }

            array[j+1] = value;
        }

        printArray(array);
    }


    // 冒泡排序，a表示数组，n表示数组大小
    private static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;
        }

        printArray(a);
    }



    private static void printArray(int[] array){
        for (int a : array) {
            System.out.println(a);
        }
    }
}


