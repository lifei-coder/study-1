package thread;

import java.util.concurrent.Semaphore;

/**
 * @author lifei1@songguo7.com
 * @date 2022/3/10 15:43
 */
public class PrintABC2 {
    public static Semaphore s0 = new Semaphore(1);
    public static Semaphore s1 = new Semaphore(0);
    public static Semaphore s2 = new Semaphore(0);

    public void printABC(Semaphore current, Semaphore next) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            current.acquire();
            System.out.print(Thread.currentThread().getName());
            next.release();
        }
    }

    public static void main(String[] args) {
        PrintABC2 printABC2 = new PrintABC2();
        new Thread(() -> {
            try {
                printABC2.printABC(s0, s1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                printABC2.printABC(s1, s2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try {
                printABC2.printABC(s2, s0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();

    }

}
