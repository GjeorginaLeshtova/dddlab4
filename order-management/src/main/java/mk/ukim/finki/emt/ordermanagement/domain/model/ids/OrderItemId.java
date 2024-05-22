package mk.ukim.finki.emt.ordermanagement.domain.model.ids;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.base.DomainObject;


import java.util.UUID;

public class OrderItemId extends DomainObjectId {
    protected OrderItemId() {
        super(UUID.randomUUID().toString());
    }

    public OrderItemId(@NonNull String uuid) {
        super(uuid);
    }

}