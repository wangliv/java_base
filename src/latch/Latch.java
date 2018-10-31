package latch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class Latch {

    //控制多少个线程完成任务打开阀门
    protected int limit;

    public Latch(int limit) {
        this.limit = limit;
    }

    public abstract void await() throws InterruptedException;

    public abstract void await(TimeUnit unit, long time)
            throws InterruptedException, TimeoutException;

    //完成任务使计数器加-1
    public abstract void countDown();

    //获取当前还有多个个线程没有到达
    public abstract int getUnarrived();

}
