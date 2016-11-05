package airlinesystem.model.operations;

import airlinesystem.model.entity.airline.Order;
import java.util.List;

public interface UserOperations extends GeneralOperations{
    public void makePaymentOrderByNumber(int number, double valor);
    public void makePaymentAllOrders(List<Order> orders);
}
