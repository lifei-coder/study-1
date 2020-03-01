package thread;

import utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * 理解中断
 */
public class Interrupted {

    public static void main(String[] args) throws Exception {
        // sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        // busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();
        // 休眠5秒, 让sleepThread和busyThread 充分运行
        /** sleepThread.interrupt() 会导致SleepUtils.second(10);这里抛出异常之前JVM会将该线程的中断标识位清除，然后抛出InterruptedException
         * 此时调用isInterrupted() 返回false
         *  **/
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread interrupted is : " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is : " + busyThread.isInterrupted());

        // 防止sleppThread和busyThread立刻退出。让main线程多执行2秒，否则jvm直接退出
        SleepUtils.second(2);

    }



    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true) {
                // 睡眠10秒
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true) {
                // 这里让他一直工作
            }
        }
    }
}
