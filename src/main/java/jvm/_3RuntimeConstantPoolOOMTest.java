package jvm;


import java.util.ArrayList;

/**
 *
 * 由于运行时常量池是方法区的一部分，因此这两个区域的溢出测试可以放在一起进行。
 * JDK1.7 开始逐步"去永久代"的事情，再此就以测试代码观察一下这件事对程序的实际影响。
 *
 * String.intern()是一个native方法
 * 作用：如果字符串常量池中已经包含了一个等于此String对象的字符串，则返回代表翅中这个字符串的String对象，
 *      否则，将此String对象包含的字符串添加到常量池中，并返回此String对象的引用。在JDK1.6及之前的版本中,由于常量池分配在永久代内，我们可以
 *      通过-XX:PermSize和-XX:MaxPermSize限制方法区大小，从而间接 限制其中常量池的容量
 *
 * VM Args: -XX: PermSize=10M -XX:MaxPermSize=10M
 */
public class _3RuntimeConstantPoolOOMTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        // 10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    /**
     * 由于本机用的jdk1.8已经去掉了永久代, -XX: PermSize=10M -XX:MaxPermSize=10M被忽略了
     * 运行结果如下：
     * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
     * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
     * jdk1.8使用元空间(Metaspace) 替代了永久代(PermSize)，因此在1.8中指定 -XX:MetaspaceSize=2m -XX:MaxMetaspaceSize=2m可以模拟此效果
     *
     */
}

