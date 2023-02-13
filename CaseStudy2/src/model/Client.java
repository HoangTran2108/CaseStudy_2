package model;

public class Client extends Person implements CalculateTheAmount, Comparable<Client>{
    private Book book;
    private String cardType;

    public Client(Book book) {
        this.book = book;
    }



    public Client(String id, String name, int age, String phoneNumber, String cardType , Book book) {
        super(id, name, age, phoneNumber);
        this.cardType = cardType;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
                ", sách mượn: " + book +
                ", số ngày mượn: " + cardType + "\n";
    }
}