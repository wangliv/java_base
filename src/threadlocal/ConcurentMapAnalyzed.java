package threadlocal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurentMapAnalyzed {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        map.put("a","dd");
        ThreadLocal<String> a = new ThreadLocal<>();
        a.set("hello");
        a.get();
        ThreadLocal<Integer> b = new ThreadLocal<Integer>();
        b.set(100);
        System.out.println(b.get());
        System.gc();
        System.gc();
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        System.out.println(b.get());
        AtomicInteger at = new AtomicInteger();
        int value = at.getAndIncrement();
        int value2 = at.getAndIncrement();
        System.out.println(value);
    }
}
