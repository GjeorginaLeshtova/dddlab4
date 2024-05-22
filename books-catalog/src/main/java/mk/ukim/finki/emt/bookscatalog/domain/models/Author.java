package mk.ukim.finki.emt.bookscatalog.domain.models;

import mk.ukim.finki.emt.bookscatalog.domain.models.ids.AuthorId;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class Author extends AbstractEntity<AuthorId> {
    private String firstname;
    private String lastname;

   protected Author(){
       super(DomainObjectId.randomId(AuthorId.class));
    }
}
