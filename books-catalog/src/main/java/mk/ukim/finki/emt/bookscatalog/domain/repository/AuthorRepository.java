package mk.ukim.finki.emt.bookscatalog.domain.repository;

import mk.ukim.finki.emt.bookscatalog.domain.models.Author;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.AuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, AuthorId> {
}
