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
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < input.length(); i++) {
            if (isChar(input.charAt(i))) {
                count++;
                hashMap.put(count, i);
            } else {
                count = 0;
            }
        }
        Set<Integer> lengthSet = hashMap.keySet();
        Integer key = lengthSet.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);
        int endIndex = hashMap.get(key) + 1;
        return input.substring(endIndex-key, endIndex);
    }

    private static boolean isChar(char c) {
        return c >= 'a' && c <= 'z';
    }

}
