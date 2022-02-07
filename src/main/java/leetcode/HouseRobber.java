package leetcode;

import java.util.Arrays;

/**
 * @author lifei1@songguo7.com
 * @date 2021/12/27 16:36
 */
public class HouseRobber {



    public static void main(String[] args) {
        int a[] = {2, 7, 9, 3, 1};
        // 第一种解法
        System.out.println("第一种递归解法："+rob(a));
        // 第二种解法
        System.out.println("第二种循环解法："+rob(a));
    }

    private static int[] memory;
    private static int rob(int[] a) {
        memory = new int[a.length];
        Arrays.fill(memory,  -1); // 都用-1占位
        return dp(a, 0);
    }

    private static int dp(int[] a, int start) {
        if (start >= a.length) {
            return 0;
        }
        if (memory[start] != -1) {
            return memory[start];
        }
        // dp(a,start+1) 表示不抢当前家直接去下一家
        // a[start] + dp(a, start + 2) 表示抢当前家，然后去下下家
        int res = Math.max(dp(a,start+1), a[start] + dp(a, start + 2));
        memory[start] = res;
        return res;
    }

    private static int robSolution2(int[] array){
        if (array == null || array.length == 0)
            return 0;
        int sum_next_next = 0;
        int sum_next = 0;
        int[] nums = new int[array.length + 2];
        for (int i = array.length - 1; i >= 0; i--) {
            nums[i] = Math.max(nums[i+1], nums[i] + nums[i+2]);
        }
        return nums[0];
    }

}
