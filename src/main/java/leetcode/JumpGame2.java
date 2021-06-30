package leetcode;

import java.util.Arrays;

/**
 * @author lifei1@songguo7.com
 * @date 2021/6/29 19:53
 */
public class JumpGame2 {

    public static void main(String[] args) {
        JumpGame2 jump =new JumpGame2();
        int [] nums={2,3,1,1,4};
        int res=jump.jump(nums);
        System.out.println("数组是"+ Arrays.toString(nums)+"需要至少跳"+res+"次");
    }

    public int jump(int[] nums) {
        int len = nums.length;
        int bounds = 0;
        int maxPosition = 0;
        int step = 0;

        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            //到了上一次的边界
            if (i == bounds) {
                //赋值边界 跳一步
                bounds = maxPosition;
                step++;
            }
        }
        return step;
    }

}
