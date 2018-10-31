package chapter17;

public interface ReadWriteLock {

    //创建Reader锁
    Lock readLock();

    //创建write锁
    Lock writeLock();

    //获取当前有多少线程正在执⾏写操作
    int getWritingWriters();

    //获取当前有多少线程正在等待获取写⼊锁
    int getWaitingWriters();

    //获取当前有多少线程正在等待获取reader锁
    int getReadingReaders();

    //⼯⼚⽅法，创建ReadWriteLock
    static ReadWriteLock readWriteLock()
    {
        return new ReadWriteLockImpl();
    }

    //⼯⼚⽅法，创建ReadWriteLock，并且传⼊preferWriter
    static ReadWriteLock readWriteLock(boolean preferWriter)
    {
        return new ReadWriteLockImpl(preferWriter);
    }

}
