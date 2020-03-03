package thread.java中的锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *  自定义同步器实现一个 自定义的锁：在同一时刻，TwinsLock允许之多两个线程的同事访问。同步资源数为2，这样可以设置初始状态status=2，当一个
 *  线程进行获取后,status减1，该线程释放则status加1.状态合法的范围为0，1，2.0表示当前已经有两个线程获取了同步资源，
 *  此时再有其他线程对同步状态进行获取，则线程只能被阻塞。
 *  在同步状态变更时，需要使用compareAndSet(int expect, int update)方法做原子性保障。
 */
public class _2TwinsLock implements Lock {

    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer{

        Sync(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for (;;) {
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current +  returnCount;
                if (compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }
    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
