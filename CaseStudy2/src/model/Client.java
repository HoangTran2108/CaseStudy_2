package model;

public class Client extends Person implements CalculateTheAmount, Comparable<Client>{
    private Book book;
    private int borrowedDays;

    public Client(Book book) {
        this.book = book;
    }

    public Client(Book book, int borrowedDays) {
        this.book = book;
        this.borrowedDays = borrowedDays;
    }

    public Client(String id, String name, int age, String phoneNumber, Book book, int borrowedDays) {
        super(id, name, age, phoneNumber);
        this.book = book;
        this.borrowedDays = borrowedDays;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBorrowedDays() {
        return borrowedDays;
    }

    public void setBorrowedDays(int borrowedDays) {
        this.borrowedDays = borrowedDays;
    }

    @Override
    public double totalMoney() {
        return this.borrowedDays*1000;
    }
    @Override
    public int compareTo(Client o) {
        return (this.getName()).compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Thẻ mượn: " + "id: " + getId() +
                ", tên người mượn: " + getName() +
                ", tuổi: " + getAge() +
                ", số điện thoại: " + getPhoneNumber() +
                ", sách mượn: " + book +
                ", số ngày mượn: " + borrowedDays + "\n";
    }
}