package fr.hb.book.service;

import java.util.List;

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
    // Trier par note moyenne

    // Afficher les données

  }

  /**
   * Find the best books by genre.
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
   * @param books the list of books
   */
  public void filterBooksPublishedBeforeYearAndShowReviews() {
    books.stream();
    // Filtrer les livres publiés avant une année
    // Afficher les critiques
  }

  /**
   * Groups the books by genre and displays the count and average rating for each
   * group.
   * 
   * @param books the list of books
   */
  public void groupBooksByGenreAndShowCountAndAverageRating() {
    books.stream();
    // Grouper les livres par genre
    // Afficher le nombre de livres et la moyenne
  }

}
