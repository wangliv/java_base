package singleton;

public class Singleton7 {

    private Singleton7(){}

    //enum，反编译后，final 类型的class,所有的成员变量都是 public static final 类型的
    //enum 可以有构造方法，普通方法，静态方法，抽象方法
    private enum Holder{
        INSTANCE;
        private Singleton7 singleton7 = null;

        Holder() {
            this.singleton7 = new Singleton7();
        }

        public Singleton7 getInstance(){
            return this.singleton7;
        }
    }

    public static Singleton7 getInstance(){
        return Holder.INSTANCE.getInstance();
    }
}
