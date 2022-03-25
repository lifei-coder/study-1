package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author lifei1@songguo7.com
 * @date 2021/12/8 15:42
 */
public class MinWindowExample {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * s = "ancahubsabdhbcasda"  t = "abc"
     */
    public static void main(String[] args) {
        System.out.println(new MinWindowExample().minWindow("abbcefabc", "abcc"));
    }

    Map<Character, Integer> tCharMap = new HashMap<Character, Integer>();
    Map<Character, Integer> windowMap = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        int beginIndex = -1;
        int endIndex = -1;
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            tCharMap.put(t.charAt(i), tCharMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int validCount = 0;
        while (right < s.length()) {
            // 记录在窗口
            if (tCharMap.containsKey(s.charAt(right))) {
                windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
                validCount++;
            }
            while (validCount == tCharMap.keySet().size()) {
                int length = right - left + 1;
                if (length < minLength) {
                    minLength = length;
                }
                beginIndex = left;
                endIndex = right;
                // 如果已经符合条件则 收缩左边窗口
                if (windowMap.containsKey(s.charAt(left))) {
                    windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
                    validCount--;
                }
                left++;
            }
            right++;
        }
        return beginIndex == -1 ? "" : s.substring(beginIndex, endIndex);
    }

}
