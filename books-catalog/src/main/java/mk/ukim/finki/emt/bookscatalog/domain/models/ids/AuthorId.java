package mk.ukim.finki.emt.bookscatalog.domain.models.ids;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class AuthorId extends DomainObjectId {
    protected AuthorId (@NonNull String uuid){
        super(uuid);
    }
}
