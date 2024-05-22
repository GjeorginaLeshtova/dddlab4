package mk.ukim.finki.emt.bookscatalog.domain.models;

import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.*;
import mk.ukim.finki.emt.bookscatalog.domain.models.enums.Categories;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.BooksId;
import mk.ukim.finki.emt.bookscatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.bookscatalog.domain.models.Author;

import java.util.List;

@Entity
@Table(name="books")
public class Books extends AbstractEntity<BooksId> {
    private String bookname;
    private Quantity quantity;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")
            ),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;
    private Author author;
    private Integer sales;
    @Enumerated(value=EnumType.STRING)
    private Categories categories;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Review> reviews;
    protected Books() {
        super(DomainObjectId.randomId(BooksId.class));
    }
    public static Books build(String bookname, Quantity quantity, Money price, Author author, Categories categories, Integer sales, List<Review> reviews){
        Books b=new Books();
        b.bookname=bookname;
        b.quantity=quantity;
        b.price=price;
        b.author=author;
        b.categories=categories;
        b.reviews=reviews;
        b.sales=sales;
        return b;
    }
    public void addSales(Integer qty) {
        this.sales = this.sales - qty;
    }

    public void removeSales(Integer qty) {
        this.sales -= qty;
    }}



