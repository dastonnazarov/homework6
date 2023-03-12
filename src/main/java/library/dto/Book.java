package library.dto;

import java.time.LocalDate;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publishYear;
    private Double amount;
    private boolean visible;


    public Book() {
    }


    public Book(Integer id, String title, String author, LocalDate publishYear, Double amount, boolean visible) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.amount = amount;
        this.visible = visible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(LocalDate publishYear) {
        this.publishYear = publishYear;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", amount=" + amount +
                ", visible=" + visible +
                '}';
    }
}
