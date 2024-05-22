package mk.ukim.finki.emt.ordermanagement.services.forms;

import lombok.Data;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Book;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Quantity;

import javax.lang.model.element.QualifiedNameable;

@Data
public class OrderItemForm {
    @NonNull
    private Book product;


    private Quantity quantity=new Quantity();
}
