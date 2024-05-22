package mk.ukim.finki.emt.bookscatalog.services;

import mk.ukim.finki.emt.bookscatalog.domain.models.Author;
import mk.ukim.finki.emt.bookscatalog.domain.models.Books;
import mk.ukim.finki.emt.bookscatalog.domain.models.Review;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.BooksId;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.ReviewId;
import mk.ukim.finki.emt.bookscatalog.services.forms.BookForm;

import java.util.List;

public interface BookService {
    Author FindAuthorById(BooksId id);
    Double getratingsavg(BooksId id);
    List<Review> findReviewsById(BooksId id);
    Books findById(BooksId id);
    Books createProduct(BookForm form);
    Books orderItemCreated(BooksId booksId, int quantity);
    Books orderItemRemoved(BooksId booksId, int quantity);
    List<Books> getAll();
    Books addReview(BooksId booksId, Review review);
    Books removeReview(BooksId booksId,Review review);

}
