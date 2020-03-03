package thread.java中的锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;


/**
 * mutex：n. 互斥；互斥元，互斥体；互斥量
 * 本例子自定义实现一个独占锁
 */
public class _1Mutex {

    private static class Sync extends AbstractQueuedSynchronizer{

        // 是否处于独占状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() ==  1;
        }

        // 当状态为0的时候获取锁
        @Override
        protected boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 释放锁， 将状态设置为0
        @Override
        protected boolean tryRelease(int releases) {
            if (getState() == 0) throw new IllegalMonitorStateException();

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回一个Condition，每个condition都包含了一个condition队列
        Condition newCondition(){
            return new ConditionObject();
        }

    }


    private final Sync sync = new Sync();
    // lock等操作通过Sync内部类代理
    public void lock() {
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock(){
        sync.release(1);
    }

    public Condition newCondition(){
        return sync.newCondition();
    }

    public boolean  isLocked(){
        return sync.isHeldExclusively();
    }


    public boolean hasQueuedThread() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

}
