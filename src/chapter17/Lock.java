package chapter17;

public interface Lock {

    /**
     * 获取显示锁
     * @throws InterruptedException
     */
    void lock() throws InterruptedException;

    /**
     * 释放锁
     */
    void unlock();
}
