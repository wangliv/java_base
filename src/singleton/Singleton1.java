package singleton;

/**
 * 饿汉式
 * 让类不可继承
 *
 * 成员属性较少，且占用内存不多
 */
public final class Singleton1 {

    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
    }

    public Singleton1 getInstance(){
        return singleton1;
    }
}
