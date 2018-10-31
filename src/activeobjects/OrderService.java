package activeobjects;


import java.util.concurrent.Future;

public interface OrderService {

    /**
     * 根据订单ID查询订单明细
     * @param orderId
     * @return
     */
    Future<String> findOrderDetails(long orderId);

    /**
     *提交订单，没有返回值
     */
    void order(String account, long orderId);

}
