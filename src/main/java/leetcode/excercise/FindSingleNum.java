package leetcode.excercise;

public class FindSingleNum {

    static int [] a1 = {11, 1, 2, 1, 2};

    public static void main(String[] args) {
        System.out.println(findSingleNum(a1));
    }


    /**
     * 亦或交换律  结合律的应用找出唯【数组】中唯一不成对出现的数字
     * @param arr
     * @return
     */
    private static int findSingleNum(int[] arr) {

        if (arr.length > 3) {
            int v = arr[0];
            for (int i = 1; i < arr.length; ++i) {
                v ^= arr[i];
            }
            return  v;
        } else {
            return -1;
        }
    }


}
