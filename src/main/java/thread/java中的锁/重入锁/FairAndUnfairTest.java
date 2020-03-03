package thread.java中的锁.重入锁;


import org.junit.jupiter.api.Test;
import utils.SleepUtils;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * ReentrantLock为可重入锁。
 * 又分为公平获取锁，非公平获取锁两个方式
 *
 * ReentrantLock 提供了如下构造函数。可选择哪种策略
 * /**
 *      * Creates an instance of {@code ReentrantLock} with the
 *      * given fairness policy.
 *
 *     public ReentrantLock(boolean fair){
 *         *sync=fair?new FairSync():new NonfairSync();
 *         *}
 *
 */
public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    // 保证线程同时开始
    static CountDownLatch begin =  new CountDownLatch(1);

    @Test
    public void fair(){
        testLock(fairLock);
    }

    @Test
    public void unfair(){
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        // 启动5个Job线程
        for(int i = 1; i <= 5; i++) {
            Thread job = new Job(fairLock, "jobThread" + i);
            job.start();
        }
        begin.countDown();
        SleepUtils.second(5);
    }


    private static class Job extends Thread {

        private Lock lock;
        public Job(Lock lock, String name) {
            super(name);//设置线程名方便查看
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                begin.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                if (lock instanceof ReentrantLock2) {
                    Collection<Thread> queuedThreads = ((ReentrantLock2) lock).getQueuedThreads();
                    String collect = queuedThreads.stream().map(Thread::getName).collect(Collectors.joining(","));
                    System.out.println("当前获取锁的线程: lock by[" + Thread.currentThread().getName() + "], waiting by ["+ collect +"]");
                    System.out.println("当前获取锁的线程: lock by[" + Thread.currentThread().getName() + "], waiting by ["+ collect +"]");
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            // 由于getQueuedThreads返回正在等待获取锁的线程列表，是逆序输出的。这里为了方便观察，将其反转
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
