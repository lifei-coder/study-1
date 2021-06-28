package leetcode;

import java.util.Arrays;

public class QuickSort {

    // 快排地推公式： quick_sort = quick_sort(p, ..., q-1) + quick_sort(q+1, ..., r)
    public static void main(String[] args) {
        int[] list = {5, 7, 3, 8, 13, 4};
        quickSort(list, 0, list.length-1);
        System.out.println(Arrays.toString(list));
    }

    private static void quickSort(int[] list, int left, int right) {
        if (left >= right)
            return;
        int midIndex = partition(list, left, right);
        quickSort(list, left, midIndex - 1);
        quickSort(list, midIndex + 1, right);
    }

    private static int partition(int[] list, int left, int right) {
        int pivot = list[right];
        int i = left;
        for (int j = left; j < list.length; j++) {
            if (list[j] < pivot) {
                int temp = list[j];
                list[j] = list[i];
                list[i++] = temp;
            }
        }
        int temp = list[i];
        list[i] = list[right];
        list[right] = temp;
        return i;
    }


}
