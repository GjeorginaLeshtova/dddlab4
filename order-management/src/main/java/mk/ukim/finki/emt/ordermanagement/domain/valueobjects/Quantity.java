package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;
@Embeddable
@Getter
public class Quantity implements ValueObject {
    private final int quantity;

    public Quantity(){
        this.quantity=0;
    }
}
