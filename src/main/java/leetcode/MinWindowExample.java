package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lifei1@songguo7.com
 * @date 2021/12/8 15:42
 */
public class MinWindowExample {

    public static void main(String[] args) {
        System.out.println(new MinWindowExample().minWindow("ADOBECODEBANC", "ABC"));
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * s = "ancahubsabdhbcasda"  t = "abc"
     * @param s
     * @param t
     * @return
     */
    Map<Character, Integer> tStringMap = new HashMap<Character, Integer>();
    Map<Character, Integer> windowMap = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int validCount = 0;
        int length = Integer.MAX_VALUE;
        int lLocate = -1, rLocate = -1;  //记录子串左右位置，最后用subString()函数取得子串
        //将t字符串的字符以及数量记录在哈希表tString里
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            tStringMap.put(c, tStringMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        //右指针是0开始
        for (right = 0; right < s.length(); right++) {
            //如果这个字符在t串中
            if (tStringMap.containsKey(s.charAt(right))) {
                // 就将这个字符记录在哈希表sString里并且个数 + 1
                windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
                validCount++;
            }
            //如果这个字串是可行的，并且左指针小于等于右指针 那么缩小窗口
            while (validCount == t.length()) {
                // 记录长度
                int subStringLength = right - left + 1;
                //如果比length更小，就更新length
                if (subStringLength < length) {
                    length = subStringLength;
                    //记录字串位置
                    lLocate = left;
                    rLocate = left + length;
                }
                // s.charAt(left) 如果是将移出窗口的字符，则需要从windowMap里减一
                if (windowMap.containsKey(s.charAt(left))) {
                    //将该字符从sString哈希表中数量 -1
                    windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
                    validCount--;
                }
                // 缩小窗口
                left++;
            }
        }

        return lLocate == -1 ? "" : s.substring(lLocate, rLocate);
    }

}
