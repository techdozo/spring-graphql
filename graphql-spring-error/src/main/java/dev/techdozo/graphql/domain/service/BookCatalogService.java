package dev.techdozo.graphql.domain.service;

import dev.techdozo.graphql.domain.model.Book;
import dev.techdozo.graphql.domain.model.Rating;
import dev.techdozo.graphql.domain.repository.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCatalogService {

  private final BookRepository bookRepository;

  public List<Rating> ratings(Book book) {
    return bookRepository.findAllRatings(book.id());
  }

  public Collection<Book> getBooks() {
    return bookRepository.findAllBooks();
  }

  public Book bookById(Integer id) {
    return bookRepository.findBookById(id);
  }
}
