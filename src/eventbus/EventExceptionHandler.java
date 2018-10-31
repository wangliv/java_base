package eventbus;


public interface EventExceptionHandler {

    void handle(Throwable cause, EventContext context);
}
