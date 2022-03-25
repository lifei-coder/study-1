package thread;

/**
 * @author lifei1@songguo7.com
 * @date 2022/3/10 15:39
 */
public class PrintABC1 {
    private int num;
    private static final Object LOCK = new Object();

    private void printABC(int targetNum) {
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                while (num % 3 != targetNum) { //想想这里为什么不能用if代替，想不起来可以看公众号上一篇文章
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC1 PrintABC = new PrintABC1();
        new Thread(() -> PrintABC.printABC(0), "A").start();
        new Thread(() -> PrintABC.printABC(1), "B").start();
        new Thread(() -> PrintABC.printABC(2), "C").start();
    }
}
