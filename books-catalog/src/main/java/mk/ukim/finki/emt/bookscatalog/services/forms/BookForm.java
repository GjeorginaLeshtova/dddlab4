package mk.ukim.finki.emt.bookscatalog.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.bookscatalog.domain.models.Author;
import mk.ukim.finki.emt.bookscatalog.domain.models.enums.Categories;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
@Data
public class BookForm {
    private String booName;
    private Money price;
    private Integer sales;
    private Categories categories;
    private Author author;
}
