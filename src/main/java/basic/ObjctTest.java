package basic;

import org.openjdk.jol.info.ClassLayout;

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
        T t = new T();
//        System.out.println(ClassLayout.parseInstance(t).toPrintable());
//
        synchronized (t) {
            System.out.println(ClassLayout.parseInstance(t).toPrintable());
        }
    }

}
