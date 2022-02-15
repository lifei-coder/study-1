package leetcode;

import java.util.Arrays;

/**
 * @author lifei1@songguo7.com
 * @date 2022/2/15 19:07
 */
public class BigNumberAdd {

    public static void main(String[] args) {
        int[] array1 = {9, 1, 2, 3, 5, 1};
        int[] array2 = {9, 1, 2, 3, 6};

        int[] result = add(array1, array2);
        for (int i = result.length-1; i >= 0; i--) {
            System.out.print(result[i]);
        }

    }

    private static int[] add(int[] array1, int [] array2) {
        int[] result = new int[Math.max(array1.length, array2.length) + 1];
        int i = array1.length - 1;
        int j = array2.length - 1;
        int index = 0;
        int tmp = 0;
        while (i >= 0 || j >= 0) {
            int a = i < 0 ? 0 : array1[i];
            int b = j < 0 ? 0 : array2[j];
            result[index++] = (a + b + tmp) % 10;
            tmp = (a + b + tmp) / 10;
            i--;
            j--;
        }
        // 如果高位有值则需要保存到result里
        if (tmp > 0) {
            result[index++] = tmp;
        }
        return result;
    }
}
