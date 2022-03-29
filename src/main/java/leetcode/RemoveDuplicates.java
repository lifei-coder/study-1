package leetcode;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int a[]  = {0, 0, 1, 1, 2, 2, 2, 3, 4, 4};
        int[][] array = {{12,3,3}, {2,3,4}};
        removeDuplicates(a);
        System.out.println(Arrays.toString(a));
    }

    public static int removeDuplicates(int[] a) {
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[j]) {
                a[++j] = a[i];
            }
        }
        return j+1;
    }
}
