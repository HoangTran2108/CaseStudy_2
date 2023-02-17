package views;

import conCreteCommand.*;
import controller.CommandManager;
import controller.LibraryManager;
import controller.LoginManager;
import model.Book;
import model.Client;
import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    LibraryManager libraryManager = new LibraryManager();
    private AddNewClient addNewClient = new AddNewClient(libraryManager);
    private AddNewEmployee addNewEmployee = new AddNewEmployee(libraryManager);
    private DisplayClient displayClient = new DisplayClient(libraryManager);
    private DisplayEmployee displayEmployee = new DisplayEmployee(libraryManager);
    private EditEmployeeById editEmployeeById = new EditEmployeeById(libraryManager);
    private RemoveClientById removeClientById = new RemoveClientById(libraryManager);
    private RemoveEmployeeById removeEmployeeById = new RemoveEmployeeById(libraryManager);
    private SearchClientById searchClientById = new SearchClientById(libraryManager);
    private SearchEmployeeById searchEmployeeById = new SearchEmployeeById(libraryManager);
    private SortClientByName sortClientByName = new SortClientByName(libraryManager);
    private SortEmployeeBySalary sortEmployeeBySalary = new SortEmployeeBySalary(libraryManager);
    private TotalRevenue totalRevenue = new TotalRevenue(libraryManager);
    private TotalSalary totalSalary = new TotalSalary(libraryManager);
    private final CommandManager commandManager = new CommandManager(addNewClient, addNewEmployee, displayClient, displayEmployee,
            editEmployeeById, removeClientById, removeEmployeeById, searchClientById, searchEmployeeById, sortClientByName,
            sortEmployeeBySalary, totalRevenue, totalSalary);
    private final LoginManager loginManager = new LoginManager();
    private final Scanner input = new Scanner(System.in);
    private int checkInput;
    public void menu() {
        do {
            System.out.println("""
                    ________Mời chọn_______
                    1. Nhân viên
                    2. Quản lý
                    0. Thoát
                    """);
            checkInput = checkInputInt();
            switch (checkInput) {
                case 1 -> employee();
                case 2 -> {
                    loginManager.loginManager();
                    manager();
                }
                case 0 -> System.out.println("Hẹn gặp lại");
                default -> System.out.println("Nhập lại");
            }
        } while (checkInput !=0);
    }
    public void employee() {
        do {
            System.out.println("""
                    ----------Menu----------
                    1. Thêm thẻ
                    2. Xóa thẻ
                    3. in danh sách
                    4. Sắp xếp thẻ theo tên và in
                    5. Tìm kiếm thẻ theo id
                    0. Quay lại.
                    _________________________
                    """);
            checkInput = checkInputInt();
            switch (checkInput) {
                case 1 -> commandManager.addNewClient(addClient());
                case 2 -> deleteCard();
                case 3 -> commandManager.displayClient();
                case 4 -> {
                    commandManager.sortClientByName();
                    commandManager.displayClient();
                }
                case 5 -> commandManager.searchClientById(String.valueOf(searchCard()));
                case 0 -> menu();
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }while (checkInput !=0);
    }
    public Client addClient() {
                System.out.println("Nhập id:");
                String id = input.nextLine();
                System.out.println("Nhập tên người dùng:");
                String name = input.nextLine();
                System.out.println("Nhập tuổi:");
                int age = checkInputInt();
                System.out.println("Nhập số điện thoại:");
                String phoneNumber =input.nextLine();
                System.out.println("Nhập Loại thẻ:");
                int cardType;
                do {
                    System.out.println("Loại thẻ gồm 1,2,3; vui lòng nhập đúng");
                    cardType = checkInputInt();
                }while (cardType !=1 && cardType !=2 && cardType !=3);
                System.out.println("Nhập số sách muốn thuê:");
                int numberBook = checkInputInt();
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
    public void deleteCard() {
        System.out.println("Nhập id muốn xóa:");
        String id = input.nextLine();
        commandManager.removeClientById(id);
    }
    public Client searchCard() {
        System.out.println("Nhập id muốn tìm:");
        String id = input.nextLine();
        commandManager.searchClientById(id);
        return null;
    }
    public void manager() {
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
                    0. Quay lại
                    _________________________
                    """);
            checkInput = checkInputInt();
            switch (checkInput) {
                case 1 -> commandManager.addNewEmployee(addEmployee());
                case 2 -> editEmployee();
                case 3 -> deleteEmployee();
                case 4 -> commandManager.displayEmployee();
                case 5 -> {
                    commandManager.sortEmployeeBySalary();
                    commandManager.displayEmployee();
                }
                case 6 -> commandManager.searchEmployeeById(String.valueOf(searchEmployee()));
                case 7 -> System.out.println(commandManager.totalSalary());
                case 8 -> System.out.println(commandManager.totalRevenue());
                case 0 -> menu();
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }while (checkInput !=0);
    }
    public Employee addEmployee() {
                System.out.println("Nhập id:");
                String id = input.nextLine();
                System.out.println("Nhập tên nhân viên:");
                String name = input.nextLine();
                System.out.println("Nhập tuổi:");
                int age = checkInputInt();
                System.out.println("Nhập số điện thoại:");
                String phoneNumber = input.nextLine();
                System.out.println("Nhập Lương cứng:");
                double hardSalary = checkInputDouble();
                System.out.println("Nhập số tiền thưởng:");
                double bonus = checkInputDouble();
                System.out.println("Nhập số tiền phạt:");
                double fine = checkInputDouble();
                return new Employee(id, name, age, phoneNumber, hardSalary, bonus,fine);
        }
    public void editEmployee() {
            System.out.println("Nhập id nhân viên muốn sửa:");
            String id = input.nextLine();
            Employee employee;
            System.out.println("Nhập tên nhân viên mới:");
            String name = input.nextLine();
            System.out.println("Nhập lại tuổi:");
            int age = checkInputInt();
            System.out.println("Nhập số điện thoại mới:");
            String phoneNumber = input.nextLine();
            System.out.println("Nhập lại lương cứng:");
            double hardSalary = checkInputDouble();
            System.out.println("Nhập lại số tiền thưởng:");
            double bonus = checkInputDouble();
            System.out.println("Nhập lại số tiền phạt:");
            double fine = checkInputDouble();
            employee = new Employee(id, name, age, phoneNumber, hardSalary, bonus,fine);
            commandManager.editEmployeeById(id, employee);
    }
    public void deleteEmployee() {
        System.out.println("Nhập id muốn xóa:");
        String id = input.nextLine();
        commandManager.removeEmployeeById(id);
    }
    public Client searchEmployee() {
        System.out.println("Nhập id muốn tìm:");
        String id = input.nextLine();
        commandManager.searchEmployeeById(id);
        return null;
    }
    //Check_________________________________
    public int checkInputInt() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số");
        }
        return -1;
    }
    public double checkInputDouble() {
        try {
            return Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số");
        }
        return -1;
    }

}