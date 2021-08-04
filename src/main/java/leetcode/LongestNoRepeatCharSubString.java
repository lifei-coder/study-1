package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifei1@songguo7.com
 * @date 2021/8/4 23:19
 */
public class LongestNoRepeatCharSubString {
    /**
     * 最长不重复字符子串
     * 要求时间复杂度： O(n)
     * @param args
     */
    public static void main(String[] args) {
        String str = "zxcaaasdq";
        System.out.println(longestNoRepeatCharSubString(str));
    }

    private static String longestNoRepeatCharSubString(String str) {
        int left = 0;
        int maxLength = 0;
        Map<Integer, String> map = new HashMap<>();
        for (; left < str.length(); left++) {
            int right = left;
            while (right < str.length()) {
                String subStr = str.substring(left, right+1);
                // 判断是否重复次数
                int repeatedCount = 0;
                for (int n = 0; n < subStr.length(); n++) {
                    if (subStr.charAt(n) == str.charAt(right)) {
                        repeatedCount++;
                    }
                    if (repeatedCount>1)  {
                        break;
                    }
                }
                if (repeatedCount>1)  {
                    break;
                }
                maxLength = Math.max(subStr.length(), maxLength);
                right++;
                map.put(subStr.length(), subStr);
            }
        }
        return map.get(maxLength);
    }


}
