package threadlocal;

import static java.lang.Thread.currentThread;

public class Example01 {
    public static void main(String[] args) throws Exception {
      /*  ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
        TimeUnit.SECONDS.sleep(30);
        threadLocal.set(new byte[1024 * 1024 * 100]); //100Mb
        threadLocal.set(new byte[1024 * 1024 * 100]); //100Mb
        threadLocal.set(new byte[1024 * 1024 * 100]); //100Mb
        threadLocal = null;*/
        currentThread().join();
    }
}
