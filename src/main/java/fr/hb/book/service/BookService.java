package fr.hb.book.service;

import java.util.List;
import java.util.stream.Collectors;

import fr.hb.book.model.Book;
import fr.hb.book.model.Review;

import fr.hb.book.data.FakeDatabase;

public class BookService {

  private List<Book> books = FakeDatabase.getBooks();
  private List<Review> reviews = FakeDatabase.getReviews();

  /**
   * Displays the list of books sorted by average rating.
   * 
   * @param books the list of books
   */
  public void displayBooksSortedByAverageRating() {
    List<Book> sortedBooks = books.stream()
        .sorted((b1, b2) -> {
          double avg1 = reviews.stream().filter(r -> r.getBook_id() == b1.getId()).mapToDouble(Review::getNote)
              .average().orElse(0.0);
          double avg2 = reviews.stream().filter(r -> r.getBook_id() == b2.getId()).mapToDouble(Review::getNote)
              .average().orElse(0.0);
          return Double.compare(avg2, avg1);
        })
        .collect(Collectors.toList());

    for (Book book : sortedBooks) {
      double averageRating = reviews.stream()
          .filter(r -> r.getBook_id() == book.getId())
          .mapToDouble(Review::getNote)
          .average()
          .orElse(0.0);
      System.out.println("Livre: " + book.getTitle() + ", Note moyenne: " + averageRating);
    }
  }

  /**
   * Find the best books by genre with the best average rating.
   * 
   * @param books the list of books
   */
  public void findBestBooksByGenre() {
    books.stream()
        .collect(Collectors.groupingBy(Book::getGenre))
        .forEach((genre, books) -> {
          reviews.stream()
              .filter(review -> review.getBook_id() == books.get(0).getId())
              .mapToDouble(review -> review.getNote())
              .average()
              .ifPresent(average -> System.out.println(
                  "Genre: " + genre + ", Meilleur livre: " + books.get(0).getTitle() + ", Note moyenne: " + average));
        });
  }

  /**
   * Filters the books published before a certain year and displays their reviews.
   * 
   * @param année
   */
  public void filterBooksPublishedBeforeYearAndShowReviews(int year) {
    books.stream()
        .filter(book -> book.getYear() < year)
        .forEach(book -> {
          System.out.println("==================================================================");
          System.out.println(" ");
          System.out.println(book.getTitle() + " " + book.getYear());
          reviews.stream()
              .filter(review -> review.getBook_id() == book.getId())
              .forEach(
                  review -> System.out.println("  - " + review.getCommentaire()));
        });
  }

  /**
   * Groups the books by genre and displays the count and average rating for each
   * group.
   * 
   * @param books the list of books
   */
  public void groupBooksByGenreAndShowCountAndAverageRating() {
    books.stream()
        .collect(Collectors.groupingBy(Book::getGenre))
        .forEach((genre, books) -> {
          System.out.println(genre + " : " + books.size() + " livres");
          reviews.stream()
              .filter(review -> review.getBook_id() == books.get(0).getId())
              .mapToDouble(review -> review.getNote())
              .average()
              .ifPresent(average -> System.out.println("  - Moyenne de la note des critiques : " + average));
        });
  }

}
