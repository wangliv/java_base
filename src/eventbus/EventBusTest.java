package eventbus;

public class EventBusTest {

    public static void main(String[] args) {
        Bus bus = new EventBus("TestBus");
        bus.register(new SimpleSubscriber1());
        bus.post("Hello");

        System.out.println("------------");
        bus.post("Hello","test");
    }
}
