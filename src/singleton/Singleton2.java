package singleton;

/**
 *懒汉式
 */
public final class Singleton2 {


    private Singleton2() {
    }

    private static Singleton2 singleton2 = null;

    public static Singleton2 getInstance(){
        if(null ==singleton2){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
