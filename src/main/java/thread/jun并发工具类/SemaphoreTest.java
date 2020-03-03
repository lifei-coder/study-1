package thread.jun并发工具类;

import utils.SleepUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore（信号量）是用来控制同时访问特定资源的线程数量。比如：
 * 有30个线程正在执行某段逻辑，只有10个线程可以同时获取某个资源(如：jdbc链接).示例代码如下：
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static Semaphore s = new Semaphore(10);

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(() -> {
                try {
                    s.acquire();
                    SleepUtils.second(2);
                    System.out.println("save jdbc data");// 输出结果会是10个一起输出。因为只能10个同时执行，
                    // 超过信号量数的被阻塞额了。等释放信号量后才能继续执行。
                    s.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
        threadPool.shutdown();
    }
}
