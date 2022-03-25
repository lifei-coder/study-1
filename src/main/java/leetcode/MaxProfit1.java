package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2021/6/28 23:13
 */
public class MaxProfit1 {

/** 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

 输入：[7,1,5,3,6,4] 输出： 输出：5

 */

    public static void main(String[] args) {
        int[] list = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(list));
    }

    private static int maxProfit(int[] list) {
        int maxProfit = 0;
        int minPrice = list[0];
        for (int i = 0 ; i < list.length; i++) {
            maxProfit = Math.max(list[i] - minPrice, maxProfit);
            minPrice = Math.min(minPrice, list[i]);
        }
        return maxProfit;
    }


}
