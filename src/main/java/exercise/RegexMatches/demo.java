package exercise.RegexMatches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {

    public static void main(String[] args) {

        String str = "+44-13238816653";
        String pattern = "^\\+([0-9]{1,4})-([0-9]+)";
        boolean isMatch = Pattern.matches(pattern, str);
        System.out.println(str + " is match :" + isMatch);


        Pattern pattern2 = Pattern.compile(pattern);
        Matcher matcher = pattern2.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }


//        Pattern p = Pattern.compile("\\d+");
//        Matcher m = p.matcher("aa22bb32");
//
//        while (m.find()) {
//            int start = m.start();
//            System.out.println(start);
//            String group = m.group();
//            System.out.println(group);
//            int end = m.end();
//            System.out.println(end);
//        }


    }





}
