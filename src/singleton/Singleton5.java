package singleton;

/**
 * Holder的方式,最好的单例设计
 */
public final class Singleton5 {

    private Singleton5(){}


    private static class Holder{
        //静态变量初始化的时机在clinit方法中,这方法是同步方法，保证了内存的可见性、JVM指令的顺序性和原子性
        private static Singleton5 singleton5 = new Singleton5();
    }

    /**
     * 使用Holdler方式
     * @return
     */
    public static Singleton5 getInstance(){
        return Holder.singleton5;
    }
}
