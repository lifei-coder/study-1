package leetcode;

import java.util.Arrays;

public class QuickSort {

    // 快排地推公式： quick_sort = quick_sort(p, ..., q-1) + quick_sort(q+1, ..., r)
    public static void main(String[] args) {
        int[] list = {5,7,3,8,13,9};
        quickSort(list, 0, list.length-1);
        System.out.println(Arrays.toString(list));
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(array, start, end);
        quickSort(array, start, mid-1);
        quickSort(array, mid+1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start;
        for (int j = start; j < array.length; j++) {
            if (array[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = array[i];
                    array[i++] = array[j];
                    array[j] = tmp;
                }
            }
        }
        // 交换Array[i] 跟 Array[end]
        int tmp = array[i];
        array[i] = array[end];
        array[end] = tmp;
        return i;
    }

}
