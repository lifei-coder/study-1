package basic;

public class ShowYanghuiTriganle {

    public static void main(String[] args) {
        final int MAX = 10;
        int[][] triangules = new int[MAX][];
        for (int i = 0; i < MAX; i++) {
            triangules[i] = new int[i+1];
        }

        for (int i = 0; i < triangules.length; i++) {
            int[] row = triangules[i];
            for (int j = 0; j < row.length; j++) {
                if (j == 0 || j == row.length - 1){
                    row[j] = 1;
                } else {
                    row[j] = triangules[i-1][j-1] + triangules[i-1][j];
                }
            }
        }

        // 第二种方式
        for (int n = 0; n < MAX; n++)
            for (int k = 0; k < triangules[n].length; k++) {
                // 计算二项式系数，n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++)
                    lotteryOdds = lotteryOdds * (n - i + 1)/i;

                triangules[n][k] = lotteryOdds;
            }

        // 输出
        for (int[] row : triangules) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

}
