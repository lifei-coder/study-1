package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class FindLongestWords {

    public static void main(String[] args) {
        String input = "123jhhy1h23hh2222@13jj";
        System.out.println("result: " + getLongString(input));
    }

    public static String getLongString(String input) {
        int count = 0;
        int maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (isChar(input.charAt(i))) {
                count++;
                maxCount = Math.max(count, maxCount);
                map.put(count, i);
            } else {
                count = 0;
            }
        }
        int endIndex = map.get(maxCount) + 1;
        return input.substring(endIndex-maxCount, endIndex);
    }

    private static boolean isChar(char c) {
        return c >= 'a' && c <= 'z';
    }

}
