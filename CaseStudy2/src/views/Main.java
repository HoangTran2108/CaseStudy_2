package views;

import controller.LibraryManager;
import model.Book;
import model.Client;
import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static LibraryManager libraryManager = new LibraryManager();
    public static Scanner input = new Scanner(System.in);
    public static int checkInput;
    public static void main(String[] args) {
        do {
            System.out.println("""
                    ________Mời chọn_______
                    1. Nhân viên
                    2. Quản lý
                    """);
            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> employee();
                case 2 -> manager();
            }
        } while (checkInput !=0);
    }
    public static void employee() {
        do {
            System.out.println("""
                    ----------Menu----------
                    1. Thêm thẻ
                    2. Xóa thẻ
                    3. in danh sách
                    4. Sắp xếp thẻ theo tên và in
                    5. Tìm kiếm thẻ theo id
                    0. Thoát
                    _________________________
                    """);
            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> libraryManager.addNewClient(addClient());
                case 2 -> deleteCard();
                case 3 -> libraryManager.displayClient();
                case 4 -> {
                    libraryManager.sortClientByName();
                    libraryManager.displayClient();
                }
                case 5 -> libraryManager.searchClientById(String.valueOf(searchCard()));
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }while (checkInput !=0);
    }
    public static Client addClient() {
            System.out.println("Nhập id:");
            String id = input.nextLine();
            System.out.println("Nhập tên người dùng:");
            String name = input.nextLine();
            System.out.println("Nhập tuổi:");
            int age = Integer.parseInt(input.nextLine());
            System.out.println("Nhập số điện thoại:");
            String phoneNumber =input.nextLine();
            System.out.println("Nhập Loại thẻ:");
            int cardType;
            do {
                System.out.println("Loại thẻ gồm 1,2,3; vui lòng nhập đúng");
                cardType = Integer.parseInt(input.nextLine());
            }while (cardType !=1 && cardType !=2 && cardType !=3);
            System.out.println("Nhập số sách muốn thuê:");
            int numberBook = Integer.parseInt(input.nextLine());
            List<Book>books = new ArrayList<>();
            for (int i = 0; i < numberBook; i++) {
                System.out.println("Nhập tên sách:");
                String nameBook = input.nextLine();
                System.out.println("Nhập tên tác giả:");
                String nameAuthor = input.nextLine();
                System.out.println("Nhập thể loại:");
                String category = input.nextLine();
                books.add(new Book(nameBook, nameAuthor, category));
            }
            return new Client(id, name, age, phoneNumber, cardType, books);
    }
    public static void deleteCard() {
        System.out.println("Nhập id muốn xóa:");
        String id = input.nextLine();
        libraryManager.removeClientById(id);
    }
    public static Client searchCard() {
        System.out.println("Nhập id muốn tìm:");
        String id = input.nextLine();
        libraryManager.searchClientById(id);
        return null;
    }
    public static void manager() {
        do {
            System.out.println("""
                    ----------Menu----------
                    1. Thêm nhân viên
                    2. Sửa thông tin nhân viên
                    3. Xóa nhân viên
                    4. in danh sách
                    5. Sắp xếp nhân viên theo lương
                    6. Tìm kiếm nhân viên theo id
                    7. Xem tổng chi
                    8. Xem tổng thu
                    0. Thoát
                    _________________________
                    """);
            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> libraryManager.addNewEmployee(addEmployee());
                case 2 -> editEmployee();
                case 3 -> deleteEmployee();
                case 4 -> libraryManager.displayEmployee();
                case 5 -> {
                    libraryManager.sortEmployeeBySalary();
                    libraryManager.displayEmployee();
                }
                case 6 -> libraryManager.searchEmployeeById(String.valueOf(searchEmployee()));
                case 7 -> System.out.println(libraryManager.totalSalary());
                case 8 -> System.out.println(libraryManager.totalRevenue());
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }while (checkInput !=0);
    }
    public static Employee addEmployee() {
            System.out.println("Nhập id:");
            String id = input.nextLine();
            System.out.println("Nhập tên nhân viên:");
            String name = input.nextLine();
            System.out.println("Nhập tuổi:");
            int age = Integer.parseInt(input.nextLine());
            System.out.println("Nhập số điện thoại:");
            String phoneNumber = input.nextLine();
            System.out.println("Nhập Lương cứng:");
            double hardSalary = Double.parseDouble(input.nextLine());
            System.out.println("Nhập số tiền thưởng:");
            double bonus = Double.parseDouble(input.nextLine());
            System.out.println("Nhập số tiền phạt:");
            double fine = Double.parseDouble(input.nextLine());
            return new Employee(id, name, age, phoneNumber, hardSalary, bonus,fine);
        }
    public static void editEmployee() {
        System.out.println("Nhập id nhân viên muốn sửa:");
        String id = input.nextLine();
        Employee employee;
            System.out.println("Nhập id mới:");
            String newId = input.nextLine();
            System.out.println("Nhập tên nhân viên mới:");
            String name = input.nextLine();
            System.out.println("Nhập lại tuổi:");
            int age = Integer.parseInt(input.nextLine());
            System.out.println("Nhập số điện thoại mới:");
            String phoneNumber = input.nextLine();
            System.out.println("Nhập lại lương cứng:");
            double hardSalary = Double.parseDouble(input.nextLine());
            System.out.println("Nhập lại số tiền thưởng:");
            double bonus = Double.parseDouble(input.nextLine());
            System.out.println("Nhập lại số tiền phạt:");
            double fine = Double.parseDouble(input.nextLine());
            employee = new Employee(newId, name, age, phoneNumber, hardSalary, bonus,fine);
            libraryManager.editEmployeeById(id, employee);
    }
    public static void deleteEmployee() {
        System.out.println("Nhập id muốn xóa:");
        String id = input.nextLine();
        libraryManager.removeEmployeeById(id);
    }
    public static Client searchEmployee() {
        System.out.println("Nhập id muốn tìm:");
        String id = input.nextLine();
        libraryManager.searchEmployeeById(id);
        return null;
    }

}