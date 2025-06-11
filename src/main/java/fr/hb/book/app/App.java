package fr.hb.book.app;

import fr.hb.book.service.ReviewService;

public class App {
  public static void main(String[] args) {
    ReviewService reviewService = new ReviewService();
    reviewService.displayReviewsByAuthorSortedByDateDesc("Alice");
  }
}
