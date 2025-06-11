package fr.hb.book.service;

import java.util.List;
import java.util.stream.Collectors;

import fr.hb.book.model.Review;
import fr.hb.book.data.FakeDatabase;

public class ReviewService {

  private List<Review> reviews = FakeDatabase.getReviews();

  /**
   * Displays the list of reviews sorted by average rating.
   * 
   * @param reviews the list of reviews
   * @param author  name
   */
  public void displayReviewsByAuthorSortedByDateDesc(String author) {
    List<Review> reviewAuthorSort = reviews.stream()
        // Trier par date de publication decroissante
        .filter(review -> review.getPseudo().equals(author))
        .sorted((r1, r2) -> r2.getDate().compareTo(r1.getDate()))
        .collect(Collectors.toList());
    // Afficher les données
    System.out.println("Liste des critiques de " + author + " triées par date décroissante :" + reviewAuthorSort);
  }

  public void getAverageRatingByBook() {
    reviews.stream()
        .filter(review -> review.getNote() > 0)
        .mapToDouble(review -> review.getNote())
        .average()
        .ifPresent(average -> System.out.println("Moyenne de la note des critiques : " + average));

  }

}
