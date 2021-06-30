package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2021/6/29 19:24
 */
public class MaxProfit2 {


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,5,4}));
    }

    private static int maxProfit(int[] list) {
        int maxProfit = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i] - list[i-1] > 0) {
                maxProfit += (list[i] - list[i-1]);
            }
        }

        return maxProfit;
    }


}
