package chapter17;

class WriteLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()){
            try {
                //⾸先使等待获取写⼊锁的数字加⼀
                readWriteLock.incrementWaitingWriters();
                //如果此时有其他线程正在进⾏读操作，或者写操作，那么当前线程将被挂起
                while (readWriteLock.getReadingReaders() > 0
                        || readWriteLock.getWritingWriters() > 0)
                {
                    readWriteLock.getMutex().wait();
                }
            } finally {
                //成功获取到了写⼊锁，使得等待获取写⼊锁的计数器减⼀
                readWriteLock.decrementWaitingWriters();
            }
            //将正在写⼊的线程数量加⼀
            readWriteLock.incrementWritingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex())
        {
            //减少正在写⼊锁的线程计数器
            readWriteLock.decrementWritingWriters();
            //将偏好状态修改为false，可以使得读锁被最快速的获得
            readWriteLock.changePrefer(false);
            //通知唤醒其他在Mutext monitor waitset中的线程
            readWriteLock.getMutex().notifyAll();
        }
    }
}
