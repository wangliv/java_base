package activeobjects;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class OrderServiceImpl implements OrderService {

    @Override
    public Future<String> findOrderDetails(long orderId) {
        FutureTask<String> future = new FutureTask<>(()->{
            try
            {
                //通过休眠来模拟该⽅法的执⾏⽐较耗时
                TimeUnit.SECONDS.sleep(10);
                System.out.println("process the orderID->" + orderId);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return "The order Details Information";
        });
        new Thread(future).start();

        return future;
    }

    @Override
    public void order(String account, long orderId) {
        try
        {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("process the order for account " + account + ",orderId " + orderId);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
