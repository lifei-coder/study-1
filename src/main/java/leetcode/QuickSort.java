package leetcode;

import java.util.Arrays;

public class QuickSort {

    // 快排地推公式： quick_sort = quick_sort(p, ..., q-1) + quick_sort(q+1, ..., r)
    public static void main(String[] args) {
        int[] list = {6, 11, 3, 9, 8};
        quickSortInternally(list, 0, list.length-1);
        System.out.println(Arrays.toString(list));
    }


    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r]; // 通常取最后一个二元素作为pivot
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j]; /// a[i++] 这里执行完赋值，再i+1。这样写少写一行代码i++.
                    a[j] = tmp;
                }
            }
        }
        // swap a[i] with  a[r]
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("i = " + i);
        return i;
    }
}
