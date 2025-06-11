package fr.hb.book.model;

import java.time.LocalDate;

public class Review {

  private String pseudo;
  private double note;
  private String commentaire;
  private LocalDate date;
  private int book_id;

  public Review(int book_id, String pseudo, double note, String commentaire, LocalDate date) {
    this.book_id = book_id;
    this.pseudo = pseudo;
    this.note = note;
    this.commentaire = commentaire;
    this.date = date;
  }

  public String getPseudo() {
    return pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  public double getNote() {
    return note;
  }

  public void setNote(double note) {
    this.note = note;
  }

  public String getCommentaire() {
    return commentaire;
  }

  public void setCommentaire(String commentaire) {
    this.commentaire = commentaire;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public int getBook_id() {
    return book_id;
  }

  public void setBook_id(int book_id) {
    this.book_id = book_id;
  }

  @Override
  public String toString() {
    return "Review [book_id=" + book_id + ", pseudo=" + pseudo + ", note=" + note + ", commentaire=" + commentaire
        + ", date=" + date + "]";
  }
}
