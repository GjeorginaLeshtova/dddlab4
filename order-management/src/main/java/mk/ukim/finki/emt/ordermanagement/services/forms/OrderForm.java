package mk.ukim.finki.emt.ordermanagement.services.forms;


import lombok.Data;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.financial.Currency;
import org.springframework.validation.annotation.Validated;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
@Data
public class OrderForm implements Source {
    @NonNull
    private Currency currency;


    @NonNull
    private List<OrderItemForm> items=new ArrayList<>();


    @Override
    public void setSystemId(String s) {

    }

    @Override
    public String getSystemId() {
        return null;
    }
}
