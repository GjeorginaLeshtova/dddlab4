package mk.ukim.finki.emt.bookscatalog.domain.repository;

import mk.ukim.finki.emt.bookscatalog.domain.models.Books;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.BooksId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, BooksId> {
}
