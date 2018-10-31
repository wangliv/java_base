package classloader;

public class ClassloaderExample02 {


    public static void main(String[] args) throws Exception {
//        System.out.println(System.getProperty("java.exta.dirs"));
        Class<?> aClass = Class.forName("User");
        System.out.println(aClass.getClassLoader());
    }
}
