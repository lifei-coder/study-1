package leetcode;

public class FindKthNumber {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 6};
        int k = 4;
        System.out.println(findKthNumber(array, 0, array.length-1, k));
    }

    private static int findKthNumber(int[] array, int left, int right, int k) {
        int q = partition(array, left, right);
        if (q+1 == k) {
            return array[q];
        } else if (q+1 < k) {
            return findKthNumber(array, q+1, right, k);
         } else if (q+1 > k) {
            return findKthNumber(array, left, q-1, k);
        }
        return 0;
    }

    private static int partition(int[] a, int left, int right) {
        int i = left;
        int pivot = a[right];
        for (int j = left; j < right; j++) {
            if (a[j] > pivot) {
                int temp = a[j];
                a[j] = a[i];
                a[i++] = temp;
            }
        }
        int tmp = a[i];
        a[i] = a[right];
        a[right] = tmp;
        return i;
    }

}
