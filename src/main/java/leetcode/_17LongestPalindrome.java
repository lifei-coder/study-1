package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2022/2/17 19:43
 */
public class _17LongestPalindrome {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数的情况
            String str1 = palindrome(s, i, i);
            // 偶数的情况
            String str2 = palindrome(s, i, i+1);
            // 取最长的回文子串
            result = result.length() > str1.length() ? result : str1;
            result = result.length() > str2.length() ? result : str2;
        }

        return result;
    }

    // 以left, right为中心的回文串
    private static String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        /** 这里left+1说明: left--是必定会执行的，当不满足的时候left是已经在前一次循环向左走了一步，right向右走了一步，
            由于substring取的是[left, right}区间，故left需要+1; 而right不用
         **/
        return s.substring(left + 1, right);
    }


}
