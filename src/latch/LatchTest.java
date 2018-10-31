package latch;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class LatchTest {
    static Random ran = new Random();

    public static void main(String[] args) throws InterruptedException, TimeoutException {
        Latch latch = new CountDownLatch(10);
        IntStream.range(0,10).forEach(i -> new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(ran.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+",done");
            latch.countDown();
        },"Thread-"+ i).start());


       /* new Thread(()->{
            while(latch.getUnarrived() > 0){
                System.out.println(latch.getUnarrived());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-counter").start();*/
        latch.await(TimeUnit.SECONDS,5);
        System.out.println(Thread.currentThread()+",done");
    }

}
