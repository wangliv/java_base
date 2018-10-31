package singleton;

/**
 * 懒汉式，同时，加同时步
 * 保证多线程下实例创建的唯一性
 */
public final class Singleton3 {

    private Singleton3() {
    }

    private static Singleton3 singleton3 = null;


    public static synchronized Singleton3 getInstance(){
        if(singleton3==null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
