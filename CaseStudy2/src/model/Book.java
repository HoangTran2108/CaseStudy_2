package model;

import java.io.Serializable;

public class Book implements Serializable {
    private String nameBook;
    private String author;
    private String category;

    public Book() {
    }

    public Book(String nameBook, String author, String category) {
        this.nameBook = nameBook;
        this.author = author;
        this.category = category;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return  "tên sách: " + nameBook +
                ", tác giả: " + author +
                ", thể loại: " + category;
    }
}