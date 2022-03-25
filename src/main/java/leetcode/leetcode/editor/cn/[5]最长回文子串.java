package leetcode.leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4927 👎 0


class longestPalindromicSubstring{
    //2022-03-24 17:56:19
    //最长回文子串
    //编号：[5]
    
    public static void main(String[] args) {
        Solution solution = new longestPalindromicSubstring().new Solution();
        // 第一种解法: 中心扩散法
        System.out.println(solution.longestPalindrome("abba"));
        // 第二种解法: 动态规划
        System.out.println(solution.longestPalindrome2("aafghhgf"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = palindrom(s, i, i);
            String str2 = palindrom(s, i, i+1);
            result = result.length() < str1.length() ? str1 : result;
            result = result.length() < str2.length() ? str2 : result;
        }
        return result;
    }

    public String palindrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    public String longestPalindrome2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLength = 0;
        int subStringLeft = 0;
        int subStringRight = 0;

        int right = 1;
        while (right < s.length()) {
            int left = 0;
            while (left < right) {
                // 判断是否为会问
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left+1][right-1])) {
                    dp[left][right] = true;
                    int length = right - left + 1;
                    if (length > maxLength) {
                        maxLength = length;
                        subStringLeft = left;
                        subStringRight = right;
                    }
                }
                left++;
            }
            right++;
        }

        return s.substring(subStringLeft, subStringRight+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}