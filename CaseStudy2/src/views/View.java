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
                    --------M???i ch???n------
                    1. Nh??n vi??n
                    2. Qu???n l??
                    0. Tho??t
                    -----------------------
                    """);
            checkInput = checkInputInt();
            switch (checkInput) {
                case 1 -> employee();
                case 2 -> {
                    loginManager.loginManager();
                    manager();
                }
                case 0 -> System.out.println("H???n g???p l???i");
                default -> System.out.println("Nh???p l???i");
            }
        } while (checkInput != 0);
    }

    public void employee() {
        do {
            System.out.println("""
                    --------------------Menu--------------------
                    1. Th??m th??? m?????n s??ch m???i
                    2. X??a th???
                    3. in danh s??ch th??? m?????n
                    4. S???p x???p th??? theo t??n v?? in
                    5. T??m ki???m th??? theo id
                    6. Th??m s??ch m???i v??o th?? vi???n
                    7. In danh s??ch s??ch ??ang l??u trong th?? vi???n
                    8. X??a s??ch kh???i th?? vi???n
                    0. Quay l???i.
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
                default -> System.out.println("Vui l??ng nh???p l???i!");
            }
        } while (checkInput != 0);
    }

    public Client addClient() {
        System.out.println("Nh???p id:");
        String id = checkClientId();
        System.out.println("Nh???p t??n ng?????i d??ng:");
        String name = string();
        System.out.println("Nh???p tu???i:");
        int age = checkInputInt();
        String phoneNumber = checkInputPhoneNumber();
        System.out.println("Nh???p Lo???i th???:");
        int cardType = checkCardType();
        System.out.println("Nh???p s??? s??ch mu???n m?????n:");
        int numberBook = checkInputInt();
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < numberBook; i++) {
            books.add(searchBook());
        }
        return new Client(id, name, age, phoneNumber, cardType, books);
    }

    public Book addBook() {
        System.out.println("Nh???p t??n s??ch:");
        String name = string();
        System.out.println("Nh???p t??n t??c gi???:");
        String author = string();
        System.out.println("Nh???p th??? lo???i:");
        String category = string();
        return new Book(name, author, category);
    }

    public void deleteCard() {
        System.out.println("Nh???p id mu???n x??a:");
        String id = string();
        System.out.println(commandManager.removeClientById(id));
    }

    public void deleteBook() {
        System.out.println("Nh???p t??n s??ch mu???n x??a:");
        String name = string();
        System.out.println(commandManager.removeBookByName(name));
    }

    public void searchCard() {
        System.out.println("Nh???p id mu???n t??m:");
        String id = string();
        System.out.println(commandManager.searchClientById(id));
    }

    public Book searchBook() {
        System.out.println("Nh???p t??n s??ch:");
        String name = string();
        Book book = commandManager.searchBookByName(name);
        commandManager.removeBookByName(name);
        return book;
    }

    public int checkCardType() {
        int cardType;
        do {
            System.out.println("Lo???i th??? g???m 1,2,3; vui l??ng nh???p ????ng");
            cardType = checkInputInt();
        } while (cardType != 1 && cardType != 2 && cardType != 3);
        return cardType;
    }

    public void manager() {
        do {
            System.out.println("""
                    --------------Menu--------------
                    1. Th??m nh??n vi??n m???i
                    2. S???a th??ng tin nh??n vi??n
                    3. X??a nh??n vi??n
                    4. in danh s??ch nh??n vi??n
                    5. S???p x???p nh??n vi??n theo l????ng
                    6. T??m ki???m nh??n vi??n theo id
                    7. Xem t???ng chi
                    8. Xem t???ng thu
                    9. ?????i m???t kh???u chung
                    10. ?????i m???t kh???u qu???n l??
                    0. Quay l???i
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
                default -> System.out.println("Vui l??ng nh???p l???i!");
            }
        } while (checkInput != 0);
    }

    public Employee addEmployee() {
        System.out.println("Nh???p id:");
        String id = checkEmployeeId();
        System.out.println("Nh???p t??n nh??n vi??n:");
        String name = string();
        System.out.println("Nh???p tu???i:");
        int age = checkInputInt();
        String phoneNumber = checkInputPhoneNumber();
        System.out.println("Nh???p L????ng c???ng:");
        double hardSalary = checkInputDouble();
        System.out.println("Nh???p s??? ti???n th?????ng:");
        double bonus = checkInputDouble();
        System.out.println("Nh???p s??? ti???n ph???t:");
        double fine = checkInputDouble();
        return new Employee(id, name, age, phoneNumber, hardSalary, bonus, fine);
    }

    public void editEmployee() {
        String id = checkEmployeeId1();
        Employee employee;
        System.out.println("Nh???p t??n nh??n vi??n m???i:");
        String name = string();
        System.out.println("Nh???p l???i tu???i:");
        int age = checkInputInt();
        String phoneNumber = checkInputPhoneNumber();
        System.out.println("Nh???p l???i l????ng c???ng:");
        double hardSalary = checkInputDouble();
        System.out.println("Nh???p l???i s??? ti???n th?????ng:");
        double bonus = checkInputDouble();
        System.out.println("Nh???p l???i s??? ti???n ph???t:");
        double fine = checkInputDouble();
        employee = new Employee(id, name, age, phoneNumber, hardSalary, bonus, fine);
        commandManager.editEmployeeById(id, employee);
    }

    public void deleteEmployee() {
        System.out.println("Nh???p id mu???n x??a:");
        String id = string();
        System.out.println(commandManager.removeEmployeeById(id));
    }

    public void searchEmployee() {
        System.out.println("Nh???p id mu???n t??m:");
        String id = string();
        System.out.println(commandManager.searchEmployeeById(id));
    }

    public void changeLogin() {
        System.out.println("Nh???p t??n ????ng nh???p m???i:");
        String userName = string();
        System.out.println("Nh???p m???t kh???u m???i:");
        String password = string();
        Login login = new Login(userName, password);
        loginManager.setLogins(login);
    }

    public void changeLoginManager() {
        System.out.println("Nh???p t??n ????ng nh???p m???i:");
        String userName = string();
        System.out.println("Nh???p m???t kh???u m???i:");
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
            System.out.println("Vui l??ng nh???p s??? theo y??u c???u");
            return checkInputInt();
        }
    }

    public double checkInputDouble() {
        try {
            return Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            System.out.println("Vui l??ng nh???p s??? theo y??u c???u");
            return checkInputDouble();
        }
    }

    public String checkEmployeeId() {
        String id = string();
        for (Employee o : libraryManager.getEmployeeList()) {
            while (true) {
                if (o.getId().equals(id)) {
                    System.out.println("id b??? tr??ng, vui l??ng nh???p l???i");
                    id = input.nextLine();
                } else {
                    break;
                }
            }
        }
        return id;
    }
    public String checkEmployeeId1() {
        System.out.println("Nh???p id nh??n vi??n mu???n s???a: ");
        String id = string();
        for (int i = 0; i < libraryManager.getEmployeeList().size(); i++) {
            if (id.equals(libraryManager.getEmployeeList().get(i).getId())) {
                return id;
            }
        }
        System.err.println("Kh??ng c?? id c??n t??m");
        return checkEmployeeId1();
    }

    public String checkClientId() {
        String id = string();
        for (Client o : libraryManager.getClientList()) {
            while (true) {
                if (o.getId().equals(id)) {
                    System.out.println("id b??? tr??ng, vui l??ng nh???p l???i");
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
            System.out.println("Nh???p s??? ??i???n tho???i: ");
            String phone = string();
            Pattern checkPhone = Pattern.compile("^0[1-9]([0-9]{8})$");
            if (checkPhone.matcher(phone).find()) {
                System.out.println("S??? ??i???n tho???i h???p l???");
                return phone;
            } else {
                System.err.println("S??? ??i???n tho???i kh??ng h???p l???");
            }
        }
    }

}