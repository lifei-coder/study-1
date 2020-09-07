package leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = {2,5,7,8,9,22,123,555,777,798};
        System.out.println("找到元素index 为: " + bsearch(list, 7));
    }


    private static int bsearch(int[] a, int value) {

        int low = 0;
        int high = a.length-1;
        while (low <= high) { // 这里 low <= high
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return -1;
    }




}
