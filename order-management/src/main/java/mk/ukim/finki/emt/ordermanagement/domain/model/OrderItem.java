package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.model.ids.OrderItemId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.BooksId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.financial.Money;

@Entity
@Table(name="order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {
    private Money itemPrice;

    @Column(nullable=false)
    private Quantity quantity;

    @AttributeOverride(name = "id", column = @Column(name = "book_id", nullable = false))
    private BooksId booksId;

    public OrderItem(@NonNull BooksId booksId, @NonNull Money itemPrice, Quantity qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.booksId = booksId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }
    protected OrderItem() {}
    public Money subtotal() {
        return itemPrice.multiply(quantity.getQuantity());
    }


}
