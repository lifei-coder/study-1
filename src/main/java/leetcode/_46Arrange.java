package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2022/2/25 15:46
 */
public class _46Arrange {

    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'b', 'c', 'd'};
        arrange(arr, 0, arr.length);
    }

    /**
     * 全排列算法
     * @param input
     * @param left
     * @param length
     */
    private static void arrange(char[] input, int left, int length) {
        if (left == length) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[j]+" ");
            }
            System.out.println();
        } else {
            for (int i = left; i < length; i++) {
                swap(input, left, i);
                arrange(input, left + 1, length);
                swap(input, left, i); // 回归状态
            }
        }
    }

    private static void swap(char[] input, int left, int i) {
        char temp = input[left];
        input[left] = input[i];
        input[i] = temp;
    }

}
