package model;

import java.io.Serializable;
import java.util.List;

public class Client extends Person implements CalculateTheAmount, Comparable<Client>,Serializable {
    private List<Book> books;
    private int cardType;

    public Client(List<Book> books, int cardType) {
        this.books = books;
        this.cardType = cardType;
    }

    public Client(String id, String name, int age, String phoneNumber, int cardType, List<Book> books) {
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

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    @Override
    public double totalMoney() {
        double totalMoney=0 ;
        if(cardType == 1){
            totalMoney = 500000;
        }
        if(cardType == 2){
            totalMoney = 300000;
        }
        if(cardType == 3){
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
        return "Thẻ hội viên " + "id: " + getId() +
                ", tên hội viên: " + getName() +
                ", tuổi: " + getAge() +
                ", số điện thoại: " + getPhoneNumber() +
                ", Loại thẻ: " + cardType + "\n" +
                "Sách mượn: " + "\n" +
                books + "\n";
    }
}