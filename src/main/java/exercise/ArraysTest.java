package exercise;

import java.util.Arrays;

/**
 * 关于数组的练习
 * 培养算法意识
 */
public class ArraysTest {
    public static void main (String[] args) {

        // 1.移除数组中重复的元素
        int[] array = {1, 1, 2, 2, 3};
        int len = removeDuplicates(array);
        for (int i = 0; i < len; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();

        // 2.旋转数组
        int[] array2 = {1, 2, 3, 4, 5};
        rotate(array2, 3);
        System.out.println(Arrays.toString(array2));


        // 3.打印数组中出现频率是1的
        int[] array3 = {1, 2, 2, 3, 3, 3, 5};
        singleNumber(array3);
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     示例 1:
     给定数组 nums = [1,1,2],
     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     你不需要考虑数组中超出新长度后面的元素。 输出{1,2}
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    /**
     *  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *  输入: [1,2,3,4,5,6,7] 和 k = 3
        输出: [5,6,7,1,2,3,4]
        解释:
        向右旋转 1 步: [7,1,2,3,4,5,6]
        向右旋转 2 步: [6,7,1,2,3,4,5]
        向右旋转 3 步: [5,6,7,1,2,3,4]
     *  要求使用空间复杂度为 O(1) 的原地算法。
     * @param nums
     * @param k
     */
    private static void rotate(int[] nums, int k) {
        if (nums == null) return;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length -1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    public static void singleNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int count = 1;
            for (int j=1; j < nums.length-i; j++) {
                if (temp == nums[j])
                    count++;
            }
            if (count == 1) {
                System.out.println("出现频率是1的数值： " + temp);
                count = 0;
            }
        }
    }
}
