package mk.ukim.finki.emt.bookscatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.ReviewId;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

import java.time.LocalDate;

@Data
@Entity
@Table(name="product_review")
public class Review extends AbstractEntity<ReviewId> {
    private Double rating;
    private String comment;
    private LocalDate date;

    protected Review(){
        super(DomainObjectId.randomId(ReviewId.class));
    }
    public void addRating(Double rating){
        this.rating+=rating;
    }
    public void removeRating(Double rating){
        this.rating-=rating;
    }
}
