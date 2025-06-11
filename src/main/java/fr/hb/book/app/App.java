package fr.hb.book.app;

import fr.hb.book.service.ReviewService;
import fr.hb.book.service.BookService;

public class App {
  public static void main(String[] args) {
    ReviewService reviewService = new ReviewService();
    BookService bookService = new BookService();

    // reviewService.displayReviewsByAuthorSortedByDateDesc("Alice");
    // reviewService.getAverageRatingByBook();

    // bookService.displayBooksSortedByAverageRating();
    bookService.findBestBooksByGenre();
    // bookService.filterBooksPublishedBeforeYearAndShowReviews(2000);
    // System.out.println("==================================================================");
    // bookService.groupBooksByGenreAndShowCountAndAverageRating();
  }
}
