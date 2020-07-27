package ee.bcs.java.demo.controller;

import javax.validation.constraints.*;

public class Book {
    private String title;
    @Email
    private String authorEmail;
    @NotNull
    private String author;
    @Min(value = 1000)
    @Max(value = 2100, message = "test")
    private int year;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
