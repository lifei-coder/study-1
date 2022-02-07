package basic;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lifei1@songguo7.com
 * @date 2021/2/24 20:39
 */
public class ObjctTest {

    private static class T {
        int m;
        boolean  b;
        String s = "hello";
    }

    public static void main(String[] args) {
        System.out.println(get());
    }

    private static int get() {
        AtomicInteger a =  new AtomicInteger(10000);
        try {
            throw new Exception();
        } catch (Exception e) {
            return a.incrementAndGet();
        } finally {
            a = new AtomicInteger(999999);
        }
    }

}
