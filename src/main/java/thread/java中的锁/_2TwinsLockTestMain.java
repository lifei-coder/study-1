package thread.java中的锁;

import org.junit.jupiter.api.Test;
import utils.SleepUtils;

import java.util.concurrent.locks.Lock;

public class _2TwinsLockTestMain {


    /**
     * 运行该测试用例，同一时刻输出两个信息，表明TwinsLock可以按照预期正确工作。
     */
    @Test
    public void test(){
        final Lock lock = new _2TwinsLock();
        class Worker extends Thread{

            Worker(String name) {
                super(name);
            }

            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName() + "睡眠了1秒");
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 启动十个线程
        for (int i = 1; i <= 10; i++) {
            Worker workerThread = new Worker("workThread" + i);
            workerThread.setDaemon(true); // daemon线程会在main线程，当jvm中不存在非daemon线程时，本例子是除了workThread外，程序跑外将退出。
            workerThread.start();
        }

        // 每隔1秒换行。持续一段时候，防止jvm退出, workThread还没开始执行就因jvm退出了中断
        for (int i = 0; i < 100; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }

}
