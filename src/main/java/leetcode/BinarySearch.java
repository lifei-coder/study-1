package leetcode;

public class BinarySearch {

    /**
     * 二分查找
     * @param args
     */
    public static void main(String[] args) {
        int[] list = {2, 5, 7, 8, 9, 22, 123, 555, 777, 798};
        System.out.println("找到元素index 为: " + bsearch(list, 22));
    }

    private static int  bsearch(int[] list, int target) {
        int left = 0;
        int right = list.length - 1;
        int mid = 0;
        while (left <= right) {
             mid = (left+right) / 2;
            if (list[mid] == target) {
                return mid;
            } else if (list[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
