package singleton;

public enum Singleton6 {

    INSTANCE;
    private  byte[] data = new byte[1024];

    Singleton6() {
        System.out.println("instace will be initialized immediately");
    }

    public static void method(){

    }
    public static Singleton6 getInstance(){
        return INSTANCE;
    }

}
