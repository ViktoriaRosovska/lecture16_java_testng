package school1.redrover.java.orders;

public class Order {
    private final long id;
    private final int customer_id;

    public Order(long id, int customer_id){
        this.id = id;
        this.customer_id = customer_id;
    }

    public long getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }
}
