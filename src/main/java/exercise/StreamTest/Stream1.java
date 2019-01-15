package exercise.StreamTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args) {
        // 简单说，对 Stream 的使用就是实现一个 filter-map-reduce 过程，产生一个最终结果，或者导致一个副作用（side effect）。
        // 一个 Stream 只可以使用一次，避免流使用多次 会报异常"stream has already been operated upon or closed"。
//        GetStream();

//        ToOtherObject();
//        OperationStream();
        ForEachLoopOperate();
    }

    /**
     * 下面提供最常见的几种构造 Stream 的样例
     */
    public static void GetStream() {
        // 1 Individual values
        Stream stream = Stream.of("a", "b", "c");

        // 2 Arrays
        String[] strings = new String[]{"aa", "bb", "cc"};
        stream = Stream.of(strings);
        stream = Arrays.stream(strings);

        // 3 Collections
        List<String> list = Arrays.asList(strings);
        stream = list.stream();
    }

    /**
     * 数值流的构造
     **/
    public static void IntStreamTest() {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    public static void ToOtherObject() {
        // 1 to Array
        Stream<String> stream = Stream.of("a", "b", "c");
        String[] strArray1 = stream.toArray(String[]::new);
        System.out.println(strArray1);
        // 2 to Collection
        List<String> list1 = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<String> list2 = Stream.of("a", "b", "c").collect(Collectors.toCollection(ArrayList::new));
        Set<String> set1 = Stream.of("a", "b", "c").collect(Collectors.toSet());
        Stack<String> stack = Stream.of("aa", "bb", "cc").collect(Collectors.toCollection(Stack::new));
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(set1.toArray());
        System.out.println(stack);
        // 3 to String
        Stream<String> stream3 = Stream.of("a", "b", "c");
        String str = stream3.collect(Collectors.joining());
        System.out.println(str);
    }

    /**
     * 当把一个数据结构包装成 Stream 后，就要开始对里面的元素进行各类操作了。常见的操作可以归类如下
     * Intermediate（中间操作， 可以继续操作流）：
     *   map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
     * Terminal（终止操作，即操作完之后流也关闭）：
     *   forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、
     *   findFirst、 findAny、 iterator
     * Short-circuiting（短路擦欧洲哦）：
     *   anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
     */
    public static void OperationStream() {
        // 转换大写
        List<String> output = Stream.of("aa", "bb", "cc").map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(output); // 输出"AA", "BB", "CC"
        // 平方数
        List<Integer> squareNum = Arrays.asList(1, 2, 3, 4).stream().map(c -> c * c).collect(Collectors.toList());
        System.out.println(squareNum);
        // 从上面例子可以看出，map 生成的是个 1:1 映射，每个输入元素，
        // 都按照规则转换成为另外一个元素。还有一些场景，是一对多映射关系的，这时需要 flatMap。
        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        Stream<Integer> outputStream = inputStream.flatMap(childList -> childList.stream());
        List<Integer> outputList = outputStream.collect(Collectors.toList());
        System.out.println(outputList);
        // flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起
        // 最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。

        // filter 对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).filter(c -> c % 2 == 0).toArray(Integer[]::new);
        System.out.println(evens); // 经过条件“被 2 整除”的 filter，剩下的数字为 {2, 4, 6}。
    }

    /**
     * forEach 方法接收一个 Lambda 表达式，然后在 Stream 的每一个元素上执行该表达式。
     */
    public static void ForEachLoopOperate() {
        String[] strings = new String[]{"tom", "thompson", "bob", "lisa"};
        List<String> nameList = Arrays.asList(strings);
        // Java 8
        nameList.stream().filter(name -> name.startsWith("t")).forEach(name -> System.out.println(name));
        // Pre-Java 8
        for (String name : nameList) {
            if (name.startsWith("t")) {
                System.out.println(name);
            }
        }
        /*
        * 当需要为多核系统优化时，可以 parallelStream().forEach()，只是此时原有元素的次序没法保证，并行的情况下将改变串行时操作的行为，
        * 此时 forEach 本身的实现不需要调整，而 Java8 以前的 for 循环 code 可能需要加入额外的多线程逻辑。
        *
        * 另外一点需要注意，forEach 是 terminal 操作，因此它执行后，Stream 的元素就被“消费”掉了，你无法对一个 Stream 进行两次 terminal 运算
        *
        * 相反，具有相似功能的 intermediate 操作 peek 可以达到上述目的。如下是出现在该 api javadoc 上的一个示例。
        * peek 对每个元素执行操作并返回一个新的 Stream
        **/
        List<String> collect = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("filtered value: " + e))
                .map(String::toUpperCase).peek(e -> System.out.println("mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(collect.toString());
    }

    /**
     * Optional。这也是一个模仿 Scala 语言中的概念，作为一个容器，它可能含有某值，或者不包含。使用它的目的是尽可能避免 NullPointerException
     * 在更复杂的 if (xx != null) 的情况中，使用 Optional 代码的可读性更好，而且它提供的是编译时检查，能极大的降低 NPE 这种RuntimeException
     * 对程序的影响，或者迫使程序员更早的在编码阶段处理空值问题，而不是留到运行时再发现和调试。
     *
     * Stream 中的 findAny、max/min、reduce 等方法等返回 Optional 值。还有例如 IntStream.average() 返回 OptionalDouble 等等。
     *
     */
    public static void OptionalDeomo() {
        String strA = " abcd ", strB = null;
        // Java8
        Optional.ofNullable(strA).ifPresent(System.out::println);
        // before Java8
        if (strA != null) {
            System.out.println(strA);
        }

        // Java8
        Integer length1 = Optional.ofNullable(strA).map(String::length).orElse(-1);
        // before Java8
        Integer length2 = strA != null ? strA.length() : -1;
    }

    public static void ReduceDemo() {
        // 字符串链接, ABCD
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
        // 求最小值
        Double minValue = Stream.of(1.0, -1.0, -3.0, 2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);
        // 求和, sumValue = 10, 有起始值
        Integer sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤, 字符串链接 concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").filter(c -> c.compareTo("Z") > 0).reduce("", String::concat);
        System.out.println(concat);
        // BinaryOperator: java.util.function.BinaryOperator是函数式接口，并且是lambda表达式。
        // BinaryOperator继承自 java.util.function.BiFunction。接收两个参数返回一个相同类型的值。例子如下
    }
}
