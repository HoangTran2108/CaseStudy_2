package views;

import controller.LibraryManager;
import model.Book;
import model.Client;
import model.Employee;
import storage.ReadAndWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static LibraryManager libraryManager = new LibraryManager();
    public static Scanner input = new Scanner(System.in);
    public static int checkInput;
    public static void main(String[] args) {

    }
    public static void employee() throws IOException {
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
                case 3 -> {
                    List<Client> clientList = ReadAndWrite.getInstance().readFileClient();
                    for (Client client: clientList) {
                        System.out.println(client);
                    }
                }
                case 4 -> { libraryManager.sortClientByName();
                    List<Client> clientList = ReadAndWrite.getInstance().readFileClient();
                    for (Client client: clientList) {
                        System.out.println(client);
                    }
                }
                case 5 -> libraryManager.searchClientById(String.valueOf(searchCard()));
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }while (checkInput !=0);
    }
    public static Client addClient() {
        Client client = null;
        try {
            System.out.println("Nhập id:");
            String id = input.nextLine();
            System.out.println("Nhập tên người dùng:");
            String name = input.nextLine();
            System.out.println("Nhập tuổi:");
            int age = Integer.parseInt(input.nextLine());
            System.out.println("Nhập số điện thoại:");
            String phoneNumber =input.nextLine();
            System.out.println("Nhập Loại thẻ:");
            String cardType = input.nextLine();
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
            client = new Client(id, name, age, phoneNumber, cardType, books);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return client;
    }
    public static void deleteCard() throws IOException {
        System.out.println("Nhập id muốn xóa:");
        String id = input.nextLine();
        System.out.println(libraryManager.removeClientById(id));;
    }
    public static Client searchCard() {
        System.out.println("Nhập id muốn tìm:");
        String id = input.nextLine();
        return libraryManager.searchClientById(id);
    }
    public static void manager() throws IOException {
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

                case 3 -> deleteEmployee();
                case 4 -> {
                    List<Client> clientList = ReadAndWrite.getInstance().readFileClient();
                    for (Client client: clientList) {
                        System.out.println(client);
                    }
                }
                case 5 -> { libraryManager.sortClientByName();
                    List<Client> clientList = ReadAndWrite.getInstance().readFileClient();
                    for (Client client: clientList) {
                        System.out.println(client);
                    }
                }
                case 6 -> libraryManager.searchClientById(String.valueOf(searchCard()));
                case 7 -> {}
                case 8 -> {}
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }while (checkInput !=0);
    }
    public static Employee addEmployee() {
        Employee employee = null;
        try {
            System.out.println("Nhập id:");
            String id = input.nextLine();
            System.out.println("Nhập tên nhân viên:");
            String name = input.nextLine();
            System.out.println("Nhập tuổi:");
            int age = Integer.parseInt(input.nextLine());
            System.out.println("Nhập số điện thoại:");
            String phoneNumber = input.nextLine();
            System.out.println("Nhập Lương cứng:");
            double hardSalary = input.nextDouble();
            System.out.println("Nhập số tiền thưởng:");
            double bonus = input.nextDouble();
            System.out.println("Nhập số tiền phạt:");
            double fine = input.nextDouble();
            employee = new Employee(id, name, age, phoneNumber, hardSalary, bonus,fine);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void deleteEmployee() throws IOException {
        System.out.println("Nhập id muốn xóa:");
        String id = input.nextLine();
        System.out.println(libraryManager.removeEmployeeById(id));
    }
    public static Client searchCard() {
        System.out.println("Nhập id muốn tìm:");
        String id = input.nextLine();
        return libraryManager.searchClientById(id);
    }

}