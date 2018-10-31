package latch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CountDownLatch extends Latch {

    private Object MUTEX = new Object();

    public CountDownLatch(int limit) {
        super(limit);
        if(limit < 0)
            throw new IllegalArgumentException("limit 必须大于0");
    }

    @Override
    public void await() throws InterruptedException {
        synchronized (MUTEX){
            while(limit > 0){
                MUTEX.wait();
            }
        }
    }

    @Override
    public void await(TimeUnit unit, long time) throws InterruptedException,TimeoutException{
        long remainingNanos = unit.toNanos(time);
        final long endTime = remainingNanos + System.nanoTime();
        synchronized (MUTEX){
            while(limit > 0){
                if(remainingNanos <= 0) throw new TimeoutException("超时");
                MUTEX.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
                remainingNanos = endTime - System.nanoTime();
            }
        }
    }

    @Override
    public void countDown() {
        synchronized (MUTEX){
            if(limit <= 0)
                throw new IllegalStateException("all thread already arrived!");
            limit--;
            MUTEX.notify();
        }
    }

    @Override
    public int getUnarrived() {
       synchronized (MUTEX){
           return limit;
       }
    }
}
