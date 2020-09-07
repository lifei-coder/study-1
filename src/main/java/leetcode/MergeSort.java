package leetcode;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // 归并排序
        int t [] = {11, 8, 3, 9, 7, 1, 2, 5};
        mergeSort(t, 0, t.length-1);
    }

    // 归并排序
    private static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;

        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }

    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= high) {
            tmp[k++] = a[j++];
        }

        for (int index = 0; index < tmp.length; index++) {
            a[index + low] = tmp[index];
        }
    }

}
