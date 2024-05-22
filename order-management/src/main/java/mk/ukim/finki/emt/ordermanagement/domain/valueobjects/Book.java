package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.financial.Money;

@Getter
public class Book implements ValueObject {

    private final BooksId id;
    private final String name;
    private final Money price;
    private final int sales;

    private Book(){
        this.id=BooksId.randomId(BooksId.class);
        this.name="";
        this.price=Money.valueOf(Currency.MKD,0);
        this.sales=0;

    }
    @JsonCreator
    public Book(@JsonProperty("id")BooksId id,
                @JsonProperty("productName") String name,
                @JsonProperty("price") Money price,
                @JsonProperty("sales") int sales){
        this.id=id;
        this.name=name;
        this.price=price;
        this.sales=sales;
    }
}
