package leetcode;

import java.util.Arrays;

public class QuickSort {

    // 快排地推公式： quick_sort = quick_sort(p, ..., q-1) + quick_sort(q+1, ..., r)
    public static void main(String[] args) {
        int[] list = {7, 6, 5, 4, 2, 3, 1};
        sort(list, 0, list.length-1);
        System.out.println(Arrays.toString(list));
    }

    private static void sort(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partion(list, start, end);
        sort(list, start, mid-1);
        sort(list, mid+1, end);
    }

    private static int partion(int[] list, int start, int end) {
        int i = start;
        int pivot = list[end];
        for (int j = start; j < end; j++) {
            if (list[j] < pivot) {
                int temp = list[j];
                list[j] = list[i];
                list[i] = temp;
                i++;
            }
        }
        int temp = list[end];
        list[end] = list[i];
        list[i] = temp;
        return i;
    }


}
