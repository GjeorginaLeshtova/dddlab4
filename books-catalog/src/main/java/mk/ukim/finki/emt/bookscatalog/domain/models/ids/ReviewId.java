package mk.ukim.finki.emt.bookscatalog.domain.models.ids;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class ReviewId extends DomainObjectId {
    protected ReviewId(@NonNull String uuid){
        super(uuid);
    }
}
