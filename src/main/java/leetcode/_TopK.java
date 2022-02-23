package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author lifei1@songguo7.com
 * @date 2022/2/21 16:26
 */
public class _TopK {
    public static void main(String[] args) {
        int[] testData = new int[]{1,4,6,2,5,9,7};
        System.out.println(Arrays.toString(findTopK(testData, 4)));
    }

    private static int[] findTopK(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] result = new int[k];
        for (int num : array) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.poll();
        }
        return result;
    }
}
