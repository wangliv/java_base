package singleton;

/**
 * 懒汉式，同时使用Double check
 *  先判断为空才，进入同代码块，创建实现，同时
 *  在进入同步代码后，再次判断实例是不为空
 *  这样只有第一次会进入同步代码块
 *  之后都直接返回
 *
 */
public class Singleton4 {

    private static Singleton4 singleton4 = null;

    private Singleton4() {
    }

    //只有第一次创建时才会，走同步代码块，高效，懒
    public static Singleton4 getInstance(){
        if(singleton4==null){
            synchronized (Singleton4.class){
                //double-check
                if(singleton4==null){
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
