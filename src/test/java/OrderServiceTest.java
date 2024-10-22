import org.testng.Assert;
import org.testng.annotations.Test;
import school1.redrover.java.orders.*;

public class OrderServiceTest {
    @Test(expectedExceptions = OrderNotFoundException.class)
    void testMissingOrder() {
        new OrderService(new TestOrderRepository()).findByIdForCustomer(100, 12);
    }

    @Test(expectedExceptions = UnauthorizedOrderAccessException.class)

    void testUnauthorizedAccess(){
        new OrderService(new TestOrderRepository()).findByIdForCustomer(1000, 123);
    }

    @Test
    void testExistingOrder(){
        Order order = new OrderService(new TestOrderRepository()).findByIdForCustomer(1000,12);
        Assert.assertEquals(order.getId(), existingOrder.getId());
        Assert.assertEquals(order.getCustomer_id(), existingOrder.getCustomer_id());
    }

    static Order existingOrder = new Order(1000, 12);
        static class TestOrderRepository implements OrderRepository {
        @Override
        public Order findById(long id){
            if (id == existingOrder.getId()) {
                return existingOrder;
            }
            return null;
        }
    }


}
