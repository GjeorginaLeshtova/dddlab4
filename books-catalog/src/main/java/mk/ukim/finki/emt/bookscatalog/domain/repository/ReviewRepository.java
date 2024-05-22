package mk.ukim.finki.emt.bookscatalog.domain.repository;

import mk.ukim.finki.emt.bookscatalog.domain.models.Review;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, ReviewId> {
}
