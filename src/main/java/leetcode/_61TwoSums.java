package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lifei1@songguo7.com
 * @date 2022/2/17 10:20
 */
public class _61TwoSums {

    public static void main(String[] args) {
        int[] array = new int[] {3, 1, 5, 2};
        int[] result = twoSums(array, 8);
        System.out.print(Arrays.toString(result));
    }

    private static int[] twoSums(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(target - arr[i]) != null) {
                return new int[]{map.get(target - arr[i])+1, i+1};
            }
            map.put(arr[i], i);
        }
        return new int[]{0, 0};
    }
}
