package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2021/6/29 19:33
 */
public class JumpGame1 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * 示例 1:
     *
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     */

    public static void main(String[] args) {
        System.out.println(canFinish(new int[]{2, 0, 0, 1, 0}));
    }

    private static boolean canFinish(int[] list) {
        int maxLength = 0;
        for (int i = 0; i < list.length; i++) {
            maxLength = Math.max(maxLength, i + list[i]);
            if (maxLength >= list.length - 1) {
                return true;
            }
            if (maxLength <= i)
                return false;
        }
        return false;
    }


}
