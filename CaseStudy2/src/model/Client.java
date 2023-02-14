package model;

import java.util.List;

public class Client extends Person implements CalculateTheAmount, Comparable<Client>{
    private List<Book> books;
    private String cardType;

    public Client(List<Book> books, String cardType) {
        this.books = books;
        this.cardType = cardType;
    }

    public Client(String id, String name, int age, String phoneNumber, String cardType, List<Book> books) {
        super(id, name, age, phoneNumber);
        this.books = books;
        this.cardType = cardType;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public double totalMoney() {
        double totalMoney=0 ;
        if(cardType.equals("A")){
            totalMoney = 500000;
        }
        if(cardType.equals("B")){
            totalMoney = 300000;
        }
        if(cardType.equals("C")){
            totalMoney = 200000;
        }
        return totalMoney;
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
                ", sách mượn: " + books +
                ", số ngày mượn: " + cardType + "\n";
    }
}