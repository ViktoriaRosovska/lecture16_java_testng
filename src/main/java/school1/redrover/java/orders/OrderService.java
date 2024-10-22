package school1.redrover.java.orders;

public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    public Order findByIdForCustomer(long orderId, int customer_id){
        Order order = repository.findById(orderId);
        if (order == null){
            throw new OrderNotFoundException();
        }
        if (order.getCustomer_id() != customer_id){
            throw  new UnauthorizedOrderAccessException();
        }
        return order;
    }

}
