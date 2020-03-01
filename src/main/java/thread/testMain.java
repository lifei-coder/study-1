package thread;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * main方法是 main线程跟多个其他线程同时运行的
 */
public class testMain {

    public static void main(String[] args) {
        /** 获取 Java 线程管理 MXBean **/
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        /** 不需要获取同步的 monitor和synnchronizer信息， 仅获取线程和线程堆栈信息 **/
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo: threadInfos) {
            System.out.println("{" + threadInfo.getThreadId() + "} " + threadInfo.getThreadName());
        }
    }


}
