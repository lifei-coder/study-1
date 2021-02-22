package leetcode.excercise;

import java.util.Arrays;

public class MoveZeroToTail {

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 4, 15};
        moveZero(a);
        System.out.println(Arrays.toString(a));
    }

    public static void moveZero(int [] a) {
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                int tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;
                k++;
            }
        }
    }

}
