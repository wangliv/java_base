package classloader;

public class ClassloaderExample01 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Bootstrap:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));

        Class<?> name = Class.forName("Example");
        System.out.println(name);
        System.out.println(name);
    }
}
