package leetcode;

import java.util.Arrays;

public class QuickSort {

    // 快排地推公式： quick_sort = quick_sort(p, ..., q-1) + quick_sort(q+1, ..., r)
    public static void main(String[] args) {
        int[] list = {5, 7, 3, 8, 13, 9, 1};
        quickSort(list, 0, list.length-1);
        System.out.println(Arrays.toString(list));
    }

    public static void quickSort(int[] list, int left, int right) {
        if (left >= right)
            return;
        int midIndex = partition(list, left, right);
        quickSort(list, 0, midIndex-1);
        quickSort(list, midIndex + 1, right);
    }

    private static int partition(int[] list, int p, int r) {
        int pivot = list[r];
        int i = p;
        for (int j = p; j < list.length; j++) {
            if (list[j] < pivot) {
                int temp = list[j];
                list[j] = list[i];
                list[i++] = temp;
            }
        }
        int temp = list[i];
        list[i] = list[r];
        list[r] = temp;
        return i;
    }


}
