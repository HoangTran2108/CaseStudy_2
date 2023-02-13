package model;

public class Employee extends Person implements CalculateTheAmount {
    private double hardSalary;
    private double bonus;
    private double fine;

    public Employee() {
    }

    public Employee(String id, String name, int age, String phoneNumber, double hardSalary, double bonus, double fine) {
        super(id, name, age, phoneNumber);
        this.hardSalary = hardSalary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public double getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(double hardSalary) {
        this.hardSalary = hardSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
    @Override
    public double totalmoney() {
        return hardSalary + bonus - fine;
    }

    @Override
    public String toString() {
        return "Nhân viên: " + "id" + getId() +
                "Tên: " + getName() +
                ", tuổi: " + getAge() +
                ", số điện thoại: " + getPhoneNumber() +
                ", tiền thưởng: " + bonus +
                ", tiền phạt" + fine + "\n";
    }

}