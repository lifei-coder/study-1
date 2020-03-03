package thread.jun并发工具类;


import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier还提供一个更高级的构造函数CyclicBarrier(int parties, Runnable barrierAction);
 * 用于在线程达到屏障时，优先执行barrierAction,方便处理更复杂的业务场景，如下示例代码:
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        // 第一个线程创建并启动
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        // 当前Main线程
        try {
            c.await(); // 虽然main线程已经达到了屏障，但有限执行的是A线程。优先等A执行完再输出1，2
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }

}
