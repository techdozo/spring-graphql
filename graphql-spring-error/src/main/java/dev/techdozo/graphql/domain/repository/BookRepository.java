package dev.techdozo.graphql.domain.repository;

import dev.techdozo.graphql.domain.model.*;
import dev.techdozo.graphql.exception.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class BookRepository {
  private final HashMap<Integer, Book> bookStorage = new HashMap<>();
  private final HashMap<Integer, Rating> ratingStorage = new HashMap<>();

  public BookRepository() {
    bookStorage.put(1, new Book(1,"Zero to One","Peter Thiel",  "Crown Business", 16.14));
    bookStorage.put(2, new Book(2,"The Lean Startup","Eric Ries",  "VIKIN", 15.80));
    bookStorage.put(3, new Book(3,"Sapiens: A Brief History of Humankind","Yuval Noah Harari",  "Random House Uk", 18.75));
    bookStorage.put(4, new Book(4,"Atomic Habits","James Clear",  "Avery", 11.98));
    bookStorage.put(5, new Book(5,"The Subtle Art of Not Giving a F*ck","Mark Manson",  "Harper", 12.99));

    ratingStorage.put(1, new Rating(1,1,5,  "The 4 minutes that will help you decide if this book is for you", "Konstantinos Papakonstantinou"));
    ratingStorage.put(2, new Rating(2,1,3,  "Is Peter Thiel the next robber baron?", "Konstantinos Papakonstantinou"));
    ratingStorage.put(3, new Rating(3,1,3,  "Simple-minded. Is it satire? Poorly-reasoned? Historically-ignorant? Afraid of competition? IDK", "Todd Holscher"));

    ratingStorage.put(4, new Rating(4,3,5,  "The Intersubjective Realm", "P. Schuyler"));
    ratingStorage.put(5, new Rating(5,3,1,  "Don't be fooled. This book is opinion masquerading as science.", "Andrew Terhune"));
    ratingStorage.put(6, new Rating(6,3,1,  "Pretentious and pompous opinions presented as facts", "P. Daskaloff"));
  }

  public List<Rating> findAllRatings(Integer bookId) {
    return ratingStorage.values().stream().filter(r -> r.bookId().equals(bookId)).toList();
  }

  public Collection<Book> findAllBooks() {
    return bookStorage.values();
  }

  public Book findBookById(Integer bookId) {
    var book = bookStorage.get(bookId);
    if (book == null) {
      throw new ResourceNotFoundException("Book not found", Map.of("ID", String.valueOf(bookId)));
    }
    return book;
  }
}
