package leetcode;

import java.util.*;

/**
 * @author lifei1@songguo7.com
 * @date 2022/2/24 15:12
 */
public class _41LongestNoRepeatedArrayLength {

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 2, 3, 4, 5, 6, 6, 7};
        System.out.println(Arrays.toString(getMaxLengthArray(param)));
    }

    private static int[] getMaxLengthArray(int [] array){
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxLength = 0;
        int i = 0;
        while (i < array.length) {
            int j = i;
            List<Integer> list = new ArrayList<>();
            while (j < array.length) {
                if (!list.contains(array[j])) {
                    list.add(array[j]);
                    j++;
                } else {
                    maxLength = Math.max(maxLength, list.size());
                    map.put(list.size(), list);
                    break;
                }
            }
            i++;
        }

        return listToArray(map.get(maxLength));
    }

    private static int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            result[i++] = num;
        }
        return result;
    }
}
