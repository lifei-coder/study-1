package basic.StreamTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream2 {

    public static void main(String[] args) {
//        stream();

//        of();

        iterate();

        generate();

        primitive();
    }

    /**
     * 通过 stream 方法把 List 或数组转换为流
     */
    private static void stream() {
        Arrays.asList("a1", "a2", "a3").stream().forEach(System.out::println);
        Arrays.stream(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    /**
     * 通过Stream.of方法直接传入多个元素构成一个流
     */
    private static void of() {
        String arr[] = {"a", "b", "c"};
        Stream.of(arr).forEach(System.out::println);

        Stream.of("a", "b", "c").forEach(System.out::println);
        Stream.of(1, 2, "a").map(item -> ((Serializable) item).getClass().getName()).forEach(System.out::println);
    }

    /**
     * 通过Stream.iterate方法使用迭代的方式构造一个无限流，然后使用limit限制流元素个数
     */
    private static void iterate() {
        Stream.iterate(2, item -> item * 2).limit(10).forEach(System.out::println);
        Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN)).limit(10).forEach(System.out::println);
    }


    /**
     * 通过Stream.generate方法从外部传入一个提供元素的Supplier来构造无限流，然后使用limit限制
     */
    private static void generate() {
        Stream.generate(() -> "HellWorld").limit(3).forEach(System.out::println);
        Stream.generate(Math::random).limit(3).forEach(System.out::println);
    }

    /**
     * 通过IntStream或DoubleStream构造基本类型的流
     */
    private static void primitive() {
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.range(0, 3).mapToObj(i -> "x").forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        DoubleStream.of(1.1, 2.2, 3.3).forEach(System.out::println);
    }





}




//订单类
@Data
@AllArgsConstructor
@NoArgsConstructor
class Order {
    private Long id;
    private Long customerId;//顾客ID
    private String customerName;//顾客姓名
    private List<OrderItem> orderItemList;//订单商品明细
    private Double totalPrice;//总价格
    private LocalDateTime placedAt;//下单时间
}

//订单商品类
@Data
@AllArgsConstructor
@NoArgsConstructor
class OrderItem {
    private Long productId;//商品ID
    private String productName;//商品名称
    private Double productPrice;//商品价格
    private Integer productQuantity;//商品数量
}

//顾客类
@Data
@AllArgsConstructor
class Customer {
    private Long id;
    private String name;//顾客姓名
}