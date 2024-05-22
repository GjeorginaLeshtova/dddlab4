package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.model.ids.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.model.ids.OrderItemId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.ordermanagement.domain.model.enums.OrederState;
import mk.ukim.finki.emt.ordermanagement.domain.model.enums.PaymentType;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Book;



import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Order extends AbstractEntity<OrderId> {
    private Instant orderOn;
    @Enumerated(EnumType.STRING)
    private OrederState orderState;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();
    public Order(Instant now, Currency currency) {
        super(DomainObjectId.randomId(OrderId.class));
        this.orderOn = now;
        this.currency = currency;
    }
    protected Order() {
        super(DomainObjectId.randomId(OrderId.class));
    }
    public Money total() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0.0), Money::add);
    }
    public OrderItem addItem(@NonNull Book product_book, Quantity qty) {
        Objects.requireNonNull(product_book,"product must not be null");
        var item  = new OrderItem(product_book.getId(),product_book.getPrice(),qty);
        orderItemList.add(item);
        return item;
    }
    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }
}
