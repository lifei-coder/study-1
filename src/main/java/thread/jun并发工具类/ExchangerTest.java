package thread.jun并发工具类;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger是一个用于线程间协作的工具类，用于线程间数据交换，它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
 * 如果第一个线程限执行exchange()方法，它会一直等待第二个线程也执行exchange()方法，当两个线程都达到同步点，这两个线程可以
 * 交换数据，讲本线程生产出来的数据交换给对方。
 */
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        // A线程计算银行流水A
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    String exchange = exchanger.exchange(A);
                    System.out.println("线程A收到的数据是: " + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // B线程计算银行流水B
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";
                try {
                    String exchange = exchanger.exchange(B);
                    System.out.println("线程B收到的数据是: " + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }

}
