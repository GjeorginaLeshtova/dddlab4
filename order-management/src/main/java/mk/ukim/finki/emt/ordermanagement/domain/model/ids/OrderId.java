package mk.ukim.finki.emt.ordermanagement.domain.model.ids;

import lombok.NonNull;

import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;


public class OrderId extends DomainObjectId {


    protected OrderId() {
        super(OrderId.randomId(OrderId.class).getId());
    }

    public OrderId(@NonNull String uuid) {
        super(uuid);
    }

}