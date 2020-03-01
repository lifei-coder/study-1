package jvm;

/**
 * 虚拟机栈和本地方法栈OOM 测试：设置-Xss160K（HotSpot虚拟机不区分虚拟机栈和本地方法栈， 栈容量只由-Xss 参数设定）
 *
 * 1
 *
 * 虚拟机栈和本地方法栈，在Java虚拟机规范中描述了两种异常：
 * StackOverflowError: 线程请求的栈深度大于虚拟机允许的最大深度
 * OutOfMemoryError: 虚拟机扩展栈时无法申请到足够的内存空间
 */
public class _2JavaVMStackSOF {


    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        _2JavaVMStackSOF oom = new _2JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
    /**
     * 实验结果表明：在单个线程下，无论是由于栈帧（stack frame）太大还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机抛出的都是StackOverflowError异常。
     *
     */
}
