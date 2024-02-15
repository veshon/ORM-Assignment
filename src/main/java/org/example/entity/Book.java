package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private String title;
    private String publicationYear;
    private double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String id, String title, String publicationYear, double price) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public Book(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
