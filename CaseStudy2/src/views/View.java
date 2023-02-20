package views;

import controller.concreteCommand.*;
import controller.CommandManager;
import controller.LibraryManager;
import controller.LoginManager;
import model.Book;
import model.Client;
import model.Employee;
import model.Login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
    LibraryManager libraryManager = new LibraryManager();
    private final AddNewClient addNewClient = new AddNewClient(libraryManager);
    private final AddNewEmployee addNewEmployee = new AddNewEmployee(libraryManager);
    private final AddNewBook addNewBook = new AddNewBook(libraryManager);
    private final DisplayClient displayClient = new DisplayClient(libraryManager);
    private final DisplayEmployee displayEmployee = new DisplayEmployee(libraryManager);
    private final DisplayBook displayBook = new DisplayBook(libraryManager);
    private final EditEmployeeById editEmployeeById = new EditEmployeeById(libraryManager);
    private final RemoveClientById removeClientById = new RemoveClientById(libraryManager);
    private final RemoveEmployeeById removeEmployeeById = new RemoveEmployeeById(libraryManager);
    private final RemoveBookByName removeBookByName = new RemoveBookByName(libraryManager);
    private final SearchClientById searchClientById = new SearchClientById(libraryManager);
    private final SearchEmployeeById searchEmployeeById = new SearchEmployeeById(libraryManager);
    private final SearchBookByName searchBookByName = new SearchBookByName(libraryManager);
    private final SortClientByName sortClientByName = new SortClientByName(libraryManager);
    private final SortEmployeeBySalary sortEmployeeBySalary = new SortEmployeeBySalary(libraryManager);
    private final TotalRevenue totalRevenue = new TotalRevenue(libraryManager);
    private final TotalSalary totalSalary = new TotalSalary(libraryManager);
    private final CommandManager commandManager = new CommandManager(addNewClient, addNewEmployee, addNewBook,
            displayClient, displayEmployee, displayBook, editEmployeeById, removeClientById, removeEmployeeById,
            removeBookByName, searchClientById, searchEmployeeById, searchBookByName, sortClientByName, sortEmployeeBySalary, totalRevenue, totalSalary);
    private final LoginManager loginManager = new LoginManager();
    private final Scanner input = new Scanner(System.in);
    private int checkInput;

    public void menu() {
        do {
            System.out.println("""
                    --------Mời chọn------
                    1. Nhân viên
                    2. Quản lý
                    0. Thoát
                    -----------------------
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
        } while (checkInput != 0);
    }

    public void employee() {
        do {
            System.out.println("""
                    --------------------Menu--------------------
                    1. Thêm thẻ mượn sách mới
                    2. Xóa thẻ
                    3. in danh sách thẻ mượn
                    4. Sắp xếp thẻ theo tên và in
                    5. Tìm kiếm thẻ theo id
                    6. Thêm sách mới vào thư viện
                    7. In danh sách sách đang lưu trong thư viện
                    8. Xóa sách khỏi thư viện
                    0. Quay lại.
                    ---------------------------------------------
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
                case 5 -> searchCard();
                case 6 -> commandManager.addNewBook(addBook());
                case 7 -> commandManager.displayBook();
                case 8 -> deleteBook();
                case 0 -> menu();
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }

    public Client addClient() {
        System.out.println("Nhập id:");
        String id = checkClientId();
        System.out.println("Nhập tên người dùng:");
        String name = string();
        System.out.println("Nhập tuổi:");
        int age = checkInputInt();
        String phoneNumber = checkInputPhoneNumber();
        System.out.println("Nhập Loại thẻ:");
        int cardType = checkCardType();
        System.out.println("Nhập số sách muốn mượn:");
        int numberBook = checkInputInt();
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < numberBook; i++) {
            books.add(searchBook());
        }
        return new Client(id, name, age, phoneNumber, cardType, books);
    }

    public Book addBook() {
        System.out.println("Nhập tên sách:");
        String name = string();
        System.out.println("Nhập tên tác giả:");
        String author = string();
        System.out.println("Nhập thể loại:");
        String category = string();
        return new Book(name, author, category);
    }

    public void deleteCard() {
        System.out.println("Nhập id muốn xóa:");
        String id = string();
        System.out.println(commandManager.removeClientById(id));
    }

    public void deleteBook() {
        System.out.println("Nhập tên sách muốn xóa:");
        String name = string();
        System.out.println(commandManager.removeBookByName(name));
    }

    public void searchCard() {
        System.out.println("Nhập id muốn tìm:");
        String id = string();
        System.out.println(commandManager.searchClientById(id));
    }

    public Book searchBook() {
        System.out.println("Nhập tên sách:");
        String name = string();
        Book book = commandManager.searchBookByName(name);
        commandManager.removeBookByName(name);
        return book;
    }

    public int checkCardType() {
        int cardType;
        do {
            System.out.println("Loại thẻ gồm 1,2,3; vui lòng nhập đúng");
            cardType = checkInputInt();
        } while (cardType != 1 && cardType != 2 && cardType != 3);
        return cardType;
    }

    public void manager() {
        do {
            System.out.println("""
                    --------------Menu--------------
                    1. Thêm nhân viên mới
                    2. Sửa thông tin nhân viên
                    3. Xóa nhân viên
                    4. in danh sách nhân viên
                    5. Sắp xếp nhân viên theo lương
                    6. Tìm kiếm nhân viên theo id
                    7. Xem tổng chi
                    8. Xem tổng thu
                    9. Đổi mật khẩu chung
                    10. Đổi mật khẩu quản lý
                    0. Quay lại
                    --------------------------------
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
                case 6 -> searchEmployee();
                case 7 -> System.out.println(commandManager.totalSalary());
                case 8 -> System.out.println(commandManager.totalRevenue());
                case 0 -> menu();
                case 9 -> changeLogin();
                case 10 -> changeLoginManager();
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }

    public Employee addEmployee() {
        System.out.println("Nhập id:");
        String id = checkEmployeeId();
        System.out.println("Nhập tên nhân viên:");
        String name = string();
        System.out.println("Nhập tuổi:");
        int age = checkInputInt();
        String phoneNumber = checkInputPhoneNumber();
        System.out.println("Nhập Lương cứng:");
        double hardSalary = checkInputDouble();
        System.out.println("Nhập số tiền thưởng:");
        double bonus = checkInputDouble();
        System.out.println("Nhập số tiền phạt:");
        double fine = checkInputDouble();
        return new Employee(id, name, age, phoneNumber, hardSalary, bonus, fine);
    }

    public void editEmployee() {
        String id = checkEmployeeId1();
        Employee employee;
        System.out.println("Nhập tên nhân viên mới:");
        String name = string();
        System.out.println("Nhập lại tuổi:");
        int age = checkInputInt();
        System.out.println("Nhập số điện thoại mới:");
        String phoneNumber = checkInputPhoneNumber();
        System.out.println("Nhập lại lương cứng:");
        double hardSalary = checkInputDouble();
        System.out.println("Nhập lại số tiền thưởng:");
        double bonus = checkInputDouble();
        System.out.println("Nhập lại số tiền phạt:");
        double fine = checkInputDouble();
        employee = new Employee(id, name, age, phoneNumber, hardSalary, bonus, fine);
        commandManager.editEmployeeById(id, employee);
    }

    public void deleteEmployee() {
        System.out.println("Nhập id muốn xóa:");
        String id = string();
        System.out.println(commandManager.removeEmployeeById(id));
    }

    public void searchEmployee() {
        System.out.println("Nhập id muốn tìm:");
        String id = string();
        System.out.println(commandManager.searchEmployeeById(id));
    }

    public void changeLogin() {
        System.out.println("Nhập tên đăng nhập mới:");
        String userName = string();
        System.out.println("Nhập mật khẩu mới:");
        String password = string();
        Login login = new Login(userName, password);
        loginManager.setLogins(login);
    }

    public void changeLoginManager() {
        System.out.println("Nhập tên đăng nhập mới:");
        String userName = string();
        System.out.println("Nhập mật khẩu mới:");
        String password = string();
        Login login = new Login(userName, password);
        loginManager.setLoginList(login);
    }

    //Check_________________________________
    public String string() {
        while (true) {
            try {
                return input.nextLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }
    public int checkInputInt() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số theo yêu cầu");
            return checkInputInt();
        }
    }

    public double checkInputDouble() {
        try {
            return Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số theo yêu cầu");
            return checkInputDouble();
        }
    }

    public String checkEmployeeId() {
        String id = string();
        for (Employee o : libraryManager.getEmployeeList()) {
            while (true) {
                if (o.getId().equals(id)) {
                    System.out.println("id bị trùng, vui lòng nhập lại");
                    id = input.nextLine();
                } else {
                    break;
                }
            }
        }
        return id;
    }
    public String checkEmployeeId1() {
        System.out.println("Nhập id nhân viên muốn sửa: ");
        String id = string();
        for (int i = 0; i < libraryManager.getEmployeeList().size(); i++) {
            if (id.equals(libraryManager.getEmployeeList().get(i).getId())) {
                return id;
            }
        }
        System.err.println("Không có id cân tìm");
        return checkEmployeeId1();
    }

    public String checkClientId() {
        String id = string();
        for (Client o : libraryManager.getClientList()) {
            while (true) {
                if (o.getId().equals(id)) {
                    System.out.println("id bị trùng, vui lòng nhập lại");
                    id = input.nextLine();
                } else {
                    break;
                }
            }
        }
        return id;
    }

    public String checkInputPhoneNumber() {
        while (true) {
            System.out.println("Nhập số điện thoại: ");
            String phone = string();
            Pattern checkPhone = Pattern.compile("^0[1-9]([0-9]{8})$");
            if (checkPhone.matcher(phone).find()) {
                System.out.println("Số điện thoại hợp lệ");
                return phone;
            } else {
                System.err.println("Số điện thoại không hợp lệ");
            }
        }
    }

}