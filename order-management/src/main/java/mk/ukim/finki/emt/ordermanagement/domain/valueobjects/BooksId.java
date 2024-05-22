package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;


@Embeddable
public class BooksId extends DomainObjectId {
    public BooksId(){
        super(BooksId.randomId(BooksId.class).getId());
    }
    public BooksId(String uuid){
        super(uuid);
    }
}
