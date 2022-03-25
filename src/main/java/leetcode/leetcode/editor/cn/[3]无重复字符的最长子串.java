package leetcode.leetcode.editor.cn;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7199 👎 0


import java.util.HashMap;
import java.util.Map;

class longestSubstringWithoutRepeatingCharacters{
    //2022-03-24 15:34:57
    //无重复字符的最长子串
    //编号：[3]
    
    public static void main(String[] args) {
        Solution solution = new longestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        solution.lengthOfLongestSubstring("peeker");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (window.containsKey(c)) {
                // 这里start要取最大值：防止后面出现前面出现过的字符如 abba,
                // 后面的第二个'a' window.get(c)是1, 得保证start越取越大
                start = Math.max(window.get(c), start);
                System.out.println("start值：" + start);
            }
            System.out.println("index : " + index + "    start: " + start);
            max = Math.max(max, index - start + 1);
            window.put(c, index + 1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}