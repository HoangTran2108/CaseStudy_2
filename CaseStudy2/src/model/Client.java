package model;

public class Client extends Person implements CalculateTheAmount{
    public Book book;

    public Client(Book book) {
        this.book = book;
    }

    public Client(String id, String name, int age, String phoneNumber, Book book) {
        super(id, name, age, phoneNumber);
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public double totalmoney() {
        return 0;
    }
    @Override
    public String toString() {
        return "Thẻ mượn: " + "id: " + getId() +
                ", tên người mượn: " + getName() +
                ", tuổi: " + getAge() +
                ", số điện thoại: " + getPhoneNumber() +
                ", sách mượn: " + book + "\n";
    }
}