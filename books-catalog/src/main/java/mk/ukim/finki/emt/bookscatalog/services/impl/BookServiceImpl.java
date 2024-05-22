package mk.ukim.finki.emt.bookscatalog.services.impl;

import mk.ukim.finki.emt.bookscatalog.domain.exceptions.BookNotFound;
import mk.ukim.finki.emt.bookscatalog.domain.models.Author;
import mk.ukim.finki.emt.bookscatalog.domain.models.Books;
import mk.ukim.finki.emt.bookscatalog.domain.models.Review;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.BooksId;
import mk.ukim.finki.emt.bookscatalog.domain.models.ids.ReviewId;
import mk.ukim.finki.emt.bookscatalog.domain.repository.AuthorRepository;
import mk.ukim.finki.emt.bookscatalog.domain.repository.BooksRepository;
import mk.ukim.finki.emt.bookscatalog.domain.repository.ReviewRepository;
import mk.ukim.finki.emt.bookscatalog.services.BookService;
import mk.ukim.finki.emt.bookscatalog.services.forms.BookForm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Author findAuthorById(BooksId id){
        Books b= findById(id);

        return authorRepository.findById(b.getAuthor().getId()).orElseThrow(BookNotFound::new);

    }

    @Override
    public Double getRatingAvg(BooksId id) {
        Books s = findById(id);
        List<Review> reviews = s.getReviews();
        Double sum = 0.0;
        for (int i = 0; i < reviews.size(); i++) {
            sum += reviews.get(i).getRating();
        }
        return reviews.size()/sum;
    }

    @Override
    public List<Review>  findReviewsById(BooksId id) {
        Books s = findById(id);
        List<ReviewId> reviewIds = s.getReviews().stream()
                .map(r ->  r.getId())
                .collect(Collectors.toList());
        return reviewRepository.findAllById(reviewIds);
    }

    @Override
    public Books findById(BooksId id) {

        return booksRepository.findById(id).orElseThrow(BookNotFound::new);
    }

    @Override
    public Books createProduct(BookForm form) {
        Books p = Books.build(form.getBooName(),form.getPrice(),form.getSales(),form.getCategories(),form.getAuthor(),new ArrayList<>());
        booksRepository.save(p);
        return p;
    }

    @Override
    public Books orderItemCreated(BooksId booksId, int quantity) {
        Books p = findById(booksId);
        p.addSales(quantity);
        booksRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public Books orderItemRemoved(BooksId booksId, int quantity) {
        Books p = booksRepository.findById(booksId).orElseThrow(BookNotFound::new);
        p.removeSales(quantity);
        booksRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public List<Books> getAll() {
        return booksRepository.findAll();
    }

    @Override
    public Books addReview(BooksId booksId,Review review) {
        Books s = findById(booksId);
        s.getReviews().add(review);
        review.addRating(review.getRating());
        return s;
    }

    @Override
    public Books removeReview(BooksId booksId,Review review) {
        Books s = findById(booksId);
        s.getReviews().remove(review);
        review.removeRating(review.getRating());
        return s;
    }
}
