package thread;


import utils.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 创建两个线程--WaitThread和NotifyThread
 * WaitThread先获得到lock对象的锁，lock.wait()后则释放锁，当前线程进入WaitQueue, Running状态 -> Waiting状态
 * NotifyThread获得到lock对象的锁，notify后，WaitThread线程从WaitQueue进入SyncChronizeedQueue, Waiting -> Blocked状态
 * WaitThread感觉到flag变成false，则跳出循环完成共工作。
 *
 * 等待/通知的 经典范式:
 *
 * 等待方:
 * synchronized (对象) {
 *     while (条件不满足) {
 *         对象.wait();
 *     }
 *     后续处理逻辑
 * }
 *
 * 通知方:
 * synchronized (对象) {
 *     改变条件
 *     对象.notifyAll()
 * }
 *
 */
public class WaitAndNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new Notify(), "notifyThread");
        notifyThread.start();
    }


    static class Wait implements Runnable{
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock){
                // 当条件不满足时，继续wait， 同事释放lock的锁
                while (flag) {
                    System.out.println(Thread.currentThread() + "flag is true, wait@ "
                            + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();// wait会释放此对象上的锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread() + "flag is false, running@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            // 加锁，拥有lock的monitor
            synchronized (lock){
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁
                // 直到当前线程释放了lock后， WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock, notify@  "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
//                lock.notify();
                flag = false;
            }

            // 再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock again, sleep@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
