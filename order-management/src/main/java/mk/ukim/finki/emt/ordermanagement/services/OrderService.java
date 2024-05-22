package mk.ukim.finki.emt.ordermanagement.services;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.ids.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.model.ids.OrderItemId;
import mk.ukim.finki.emt.ordermanagement.services.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagement.services.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;
public class OrderService {
    OrderId placeOrder(OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException;


}
