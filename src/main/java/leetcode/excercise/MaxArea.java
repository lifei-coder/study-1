package leetcode.excercise;

public class MaxArea {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,6,5,4,3,2,1};
        System.out.println(maxArea(a));
    }



    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
            if (height[i] > height[j]){
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

}
