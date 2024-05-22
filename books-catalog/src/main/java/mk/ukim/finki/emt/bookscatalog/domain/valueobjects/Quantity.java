package mk.ukim.finki.emt.bookscatalog.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;

@Embeddable
@Getter
public class Quantity implements ValueObject {

    private final int quantity;

    protected Quantity(){
        this.quantity=0;

    }
}
