package geektime.designpattern.observer.test;

import java.io.EOFException;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/17 21:54
 */
public class TestNullPointException {

    public static void main(String[] args) throws InterruptedException {
        int  a = 0;
        while (true) {
            try {
                int b = 3 / a;
            } catch (Exception e) {
                Thread.sleep(3000);
                System.out.println(e);
            }

        }

    }
}
