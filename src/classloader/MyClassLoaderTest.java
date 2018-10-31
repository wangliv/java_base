package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader clzloader = new MyClassLoader();
        Class<?> aClass = clzloader.loadClass("think.GreetDriver");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());

       /* Object obj = aClass.newInstance();

        Method m = aClass.getMethod("say");

        m.invoke(obj);*/
    }
}
