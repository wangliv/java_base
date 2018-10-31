package think;

public class ThinkTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("think.HelloWorldGreet");
        GreetDriver.hello();
    }
}
