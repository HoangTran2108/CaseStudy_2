package controller;

import model.Book;
import model.Client;
import model.Employee;
import storage.ReadAndWrite;
import views.View;

import java.util.Collections;
import java.util.List;

public class LibraryManager {
    private final List<Client> clientList;
    private final List<Employee> employeeList;
    private final List<Book> bookList;

    public LibraryManager() {
        clientList = ReadAndWrite.getInstance().readFileClient();
        employeeList = ReadAndWrite.getInstance().readFileEmployee();
        bookList = ReadAndWrite.getInstance().readFileBook();
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public LibraryManager(List<Client> clientList, List<Employee> employeeList, List<Book> bookList) {
        this.clientList = clientList;
        this.employeeList = employeeList;
        this.bookList = bookList;
    }

    public void addNewEmployee(Employee employee) {
        employeeList.add(employee);
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }

    public void addNewClient(Client client) {
        clientList.add(client);
        ReadAndWrite.getInstance().writeFileClient(clientList);
    }

    public void addNewBook(Book book) {
        bookList.add(book);
        ReadAndWrite.getInstance().writeFileBook(bookList);
    }

    public void editEmployeeById(String inputID, Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (inputID.equals(employeeList.get(i).getId())) {
                employeeList.set(i, employee);
                break;
            }
        }
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }

    public String removeEmployeeById(String inputID) {
        for (Employee employee : employeeList) {
            if (inputID.equals(employee.getId())) {
                employeeList.remove(employee);
                ReadAndWrite.getInstance().writeFileEmployee(employeeList);
                return "X??a th??nh c??ng";
            }
        }
        return "Kh??ng t??m th???y id";
    }

    public String removeClientById(String inputID) {
        for (Client client : clientList) {
            if (inputID.equals(client.getId())) {
                List<Book> bookList1 = client.getBooks();
                bookList.addAll(bookList1);
                ReadAndWrite.getInstance().writeFileBook(bookList);
                clientList.remove(client);
                ReadAndWrite.getInstance().writeFileClient(clientList);
                return "x??a th??nh c??ng";
            }
        }
        return "Kh??ng t??m th???y id";
    }

    public String removeBookByName(String name) {
        for (Book book : bookList) {
            if (name.equals(book.getNameBook())) {
                bookList.remove(book);
                ReadAndWrite.getInstance().writeFileBook(bookList);
                return "S??ch ???? ???????c x??a kh???i th?? vi???n";
            }
        }
        return "Kh??ng t??m th???y t??n s??ch";
    }

    public void sortEmployeeBySalary() {
        Collections.sort(employeeList);
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }

    public void sortClientByName() {
        Collections.sort(clientList);
        ReadAndWrite.getInstance().writeFileClient(clientList);
    }

    public void displayClient() {
        for (Client client : clientList) {
            System.out.println(client);
        }
    }

    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void displayBook() {
        List<Book> bookList1 = ReadAndWrite.getInstance().readFileBook();
        for (Book book : bookList1) {
            System.out.println(book);
        }
    }

    public String totalSalary() {
        StringBuilder stringBuilder = new StringBuilder();
        double sumSalary = 0;
        for (Employee employee : employeeList) {
            sumSalary += employee.totalMoney();
        }
        stringBuilder.append("T???ng ti???n ph???i tr??? cho t???t c??? nh??n vi??n l??: ").append(sumSalary);
        return stringBuilder.toString();
    }

    public String totalRevenue() {
        StringBuilder stringBuilder = new StringBuilder();
        double sumRevenue = 0;
        for (Client client : clientList) {
            sumRevenue += client.totalMoney();
        }
        stringBuilder.append("T???ng ti???n d??? ki???n thu ???????c t??? phi???u m?????n s??ch: ").append(sumRevenue);
        return stringBuilder.toString();
    }

    public String searchEmployeeById(String inputID) {
        for (Employee employee : employeeList) {
            if (inputID.equals(employee.getId())) {
                return employee.toString();
            }
        }
        return "Kh??ng t??m th???y id";
    }

    public String searchClientById(String inputID) {
        for (Client client : clientList) {
            if (inputID.equals(client.getId())) {
                return client.toString();
            }
        }
        return "Kh??ng t??m th???y id";
    }

    public Book searchBookByName(String name) {
        View view = new View();
        for (Book book : bookList) {
            if (name.equals(book.getNameBook())) {
                return book;
            }
        }
        return view.searchBook();
    }
}