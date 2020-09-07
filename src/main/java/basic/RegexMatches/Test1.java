package basic.RegexMatches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    public static void main(String [] args) {
        matchStringTest();
        groupCountTest();
        regexGrammarTest();
    }

    private static void matchStringTest() {
        String content1 = "I am noob from baidu.com";
        String pattern = ".*baidu.*"; //
        boolean isMatch1 = Pattern.matches(pattern, content1);
        System.out.println(isMatch1);
        String content2 = "I am noob from tencent.com";
        boolean isMatch2 = Pattern.matches(pattern, content2);
        System.out.println(isMatch2);
    }

    /**
     * 捕获组
     * 捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
     * 例如，正则表达式 (dog) 创建了单一分组，组里包含"d"，"o"，和"g"。
     * 捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：((A)(B(C))), (A), (B(C)), (C)
     */
    private static void groupCountTest() {
        String line = "This order was placed for QT3000! OK?";
        // 在 Java 中\\ 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。
        String pattern = "(\\D*)(\\d+)(.*)"; // 也就是正则表达式->(D*)(d+)(.*)
        // 创建Pattern对象
        Pattern r = Pattern.compile(pattern);
        // 创建matcher对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("Not Match");
        }
    }

    /**
     * 正则表达式语法
     *
     */
    public static void regexGrammarTest() {
        // "\": 将下一字符标记为特殊字符、文本、反向引用或八进制转义符。例如，"n"匹配字符"n"。"\n"匹配换行符。序列"\\\\"匹配"\\"，"\\("匹配"("。

        // "^": 匹配输入字符串开始的位置。如果设置了 RegExp 对象的 Multiline 属性，^ 还会与"\n"或"\r"之后的位置匹配。
        testPattern("^a", "a");

        // "$": 匹配输入字符串结尾的位置。如果设置了 RegExp 对象的 Multiline 属性，$ 还会与"\n"或"\r"之前的位置匹配。
        testPattern("b$", "b");

        // "*": 零次或多次匹配前面的字符或子表达式。例如，zo* 匹配"z"和"zoo"。* 等效于 {0,}。
        // "+": 一次或多次匹配前面的字符或子表达式。例如，"zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+ 等效于 {1,}。
        // "?": 零次或一次匹配前面的字符或子表达式。例如，"do(es)?"匹配"do"或"does"中的"do"。? 等效于 {0,1}。
        // ".": 匹配除"\r\n"之外的任何单个字符。若要匹配包括"\r\n"在内的任意字符，请使用诸如"[\s\S]"之类的模式。
        testPattern(".*a$", "a1a2a3a4a");
        testPattern(".+a$", "1a");

        // "{n}": n 是非负整数。正好匹配 n 次。例如，"o{2}"与"Bob"中的"o"不匹配，但与"food"中的两个"o"匹配。
        // "{n,}": n 是非负整数。至少匹配 n 次。例如，"o{2,}"不匹配"Bob"中的"o",而匹配"foood"中的所有 o, "o{1,}"等效于"o+"。"o{0,}"等效于"o*"。
        // "{n,m}": m 和 n 是非负整数，其中 n <= m, 匹配至少 n 次，至多 m 次。例如，"o{1,3}"匹配"fooooood"中的头三个 o。'o{0,1}'
        //          等效于 'o?'。注意：您不能将空格插入逗号和数字之间。
        testPattern("fo{2}d", "food");
        testPattern("fo{2,}d", "food");
        testPattern("fo{1,3}d", "fod");
        // "x|y": 匹配 x 或 y。例如，'z|food' 匹配"z"或"food"。'(z|f)ood' 匹配"zood"或"food"。
        // "[xyz]": 字符集。匹配包含的任一字符。例如，"[abc]"匹配"plain"中的"a"。
        // "[^xyz]": 反向字符集。匹配未包含的任何字符。例如，"[^abc]"匹配"plain"中"p"，"l"，"i"，"n"。
        // "[z-a]": 字符范围。匹配指定范围内的任何字符。例如，"[a-z]"匹配"a"到"z"范围内的任何小写字母。
        testPattern("(z|f)ood", "zood");
        testPattern("[123abc]", "a");
        testPattern("[^123abc]", "e");
        testPattern("[a-d]", "g");
        // "\d": 数字字符匹配。等效于 [0-9]。
        // "\D": 非数字字符匹配。等效于 [^0-9]。
        testPattern("\\d{2,4}", "1311");
        testPattern("\\D{1,4}", "+-*/");
    }


    private static boolean testPattern(String pattern, String content) {
        boolean matches = Pattern.matches(pattern, content);
        System.out.println(content + " matches \"" + pattern + "\": " + matches );
        return matches;
    }
}