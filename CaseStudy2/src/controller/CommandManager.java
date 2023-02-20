package controller;

import controller.concreteCommand.*;
import model.Book;
import model.Client;
import model.Employee;

public class CommandManager {
    AddNewClient addNewClient;
    AddNewEmployee addNewEmployee;
    AddNewBook addNewBook;
    DisplayClient displayClient;
    DisplayEmployee displayEmployee;
    DisplayBook displayBook;
    EditEmployeeById editEmployeeById;
    RemoveClientById removeClientById;
    RemoveEmployeeById removeEmployeeById;
    RemoveBookByName removeBookByName;
    SearchClientById searchClientById;
    SearchEmployeeById searchEmployeeById;
    SearchBookByName searchBookByName;
    SortClientByName sortClientByName;
    SortEmployeeBySalary sortEmployeeBySalary;
    TotalRevenue totalRevenue;
    TotalSalary totalSalary;

    public CommandManager(AddNewClient addNewClient, AddNewEmployee addNewEmployee, AddNewBook addNewBook,
                          DisplayClient displayClient, DisplayEmployee displayEmployee, DisplayBook displayBook, EditEmployeeById editEmployeeById,
                          RemoveClientById removeClientById, RemoveEmployeeById removeEmployeeById, RemoveBookByName removeBookByName,
                          SearchClientById searchClientById, SearchEmployeeById searchEmployeeById, SearchBookByName searchBookByName,
                          SortClientByName sortClientByName, SortEmployeeBySalary sortEmployeeBySalary, TotalRevenue totalRevenue, TotalSalary totalSalary) {
        this.addNewClient = addNewClient;
        this.addNewEmployee = addNewEmployee;
        this.addNewBook = addNewBook;
        this.displayClient = displayClient;
        this.displayEmployee = displayEmployee;
        this.displayBook = displayBook;
        this.editEmployeeById = editEmployeeById;
        this.removeClientById = removeClientById;
        this.removeEmployeeById = removeEmployeeById;
        this.removeBookByName = removeBookByName;
        this.searchClientById = searchClientById;
        this.searchEmployeeById = searchEmployeeById;
        this.searchBookByName = searchBookByName;
        this.sortClientByName = sortClientByName;
        this.sortEmployeeBySalary = sortEmployeeBySalary;
        this.totalRevenue = totalRevenue;
        this.totalSalary = totalSalary;
    }

    public void addNewEmployee(Employee employee){
        addNewEmployee.execute(employee);
    }
    public void addNewClient(Client client) {
        addNewClient.execute(client);
    }
    public void addNewBook(Book book) {
        addNewBook.execute(book);
    }
    public void editEmployeeById(String inputID, Employee employee) {
        editEmployeeById.execute(inputID, employee);
    }
    public String removeEmployeeById(String inputID) {
        return removeEmployeeById.execute(inputID);
    }
    public String removeClientById(String inputID) {
        return removeClientById.execute(inputID);
    }
    public String removeBookByName(String name) {
        return removeBookByName.execute(name);
    }
    public void sortEmployeeBySalary(){
        sortEmployeeBySalary.execute();
    }
    public void sortClientByName() {
        sortClientByName.execute();
    }
    public void displayClient() {
        displayClient.execute();
    }
    public void displayEmployee() {
        displayEmployee.execute();
    }
    public void displayBook(){
        displayBook.execute();
    }
    public String totalSalary(){
        return totalSalary.execute();
    }
    public String totalRevenue(){
        return totalRevenue.execute();
    }
    public String searchEmployeeById(String inputID){
        return searchEmployeeById.execute(inputID);
    }
    public String searchClientById(String inputID){
        return searchClientById.execute(inputID);
    }
    public Book searchBookByName(String name){
        return searchBookByName.execute(name);
    }
}