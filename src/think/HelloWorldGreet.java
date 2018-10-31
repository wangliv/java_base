package think;

public class HelloWorldGreet implements Greet {

    static{
        GreetDriver.registerDriver(new HelloWorldGreet());
    }
    @Override
    public void hello() {
        System.out.println("java hello world is a good time to do that ....");
    }
}
