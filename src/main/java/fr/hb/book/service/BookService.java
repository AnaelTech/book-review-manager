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
    books.stream();
    // Rechercher la note moyenne de chaque livre dasns la liste de reviews

    // Trier par note moyenne

    // Afficher les données

  }

  /**
   * Find the best books by genre with the best average rating.
   * 
   * @param books the list of books
   */
  public void findBestBooksByGenre() {
    books.stream();
    // Trier par note moyenne
    // Et Sortir le meilleur genre
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

    // Filtrer les livres publiés avant une année ✅
    // Afficher les critiques
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
    // Grouper les livres par genre ✅
    // Afficher le nombre de livres ✅
    // et la moyenne ✅
  }

}
