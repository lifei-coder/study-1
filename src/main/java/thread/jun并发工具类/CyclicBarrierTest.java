package thread.jun并发工具类;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 同步屏障CyclicBarrier
 * 它要做的事情是：让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被拦截的线程才会继续运行
 *
 * CyclicBarrier默认的构造方法是CyclicBarrier(int parties)其参数表示屏障拦截的线程数，
 * 每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。如下为示例代码
 */
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);//如果改成3，则没有第三个线程
    // 调用cyclicBarrier.await方法没有第三个线程达到屏障，所以之前两个线程都不会继续运行，会一直等待

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
