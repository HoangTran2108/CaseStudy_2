package controller;

import concreteCommand.*;
import model.Client;
import model.Employee;

import java.util.List;

public class CommandManager {
    AddNewClient addNewClient;
    AddNewEmployee addNewEmployee;
    DisplayClient displayClient;
    DisplayEmployee displayEmployee;
    EditEmployeeById editEmployeeById;
    RemoveClientById removeClientById;
    RemoveEmployeeById removeEmployeeById;
    SearchClientById searchClientById;
    SearchEmployeeById searchEmployeeById;
    SortClientByName sortClientByName;
    SortEmployeeBySalary sortEmployeeBySalary;
    TotalRevenue totalRevenue;
    TotalSalary totalSalary;

    public CommandManager(AddNewClient addNewClient, AddNewEmployee addNewEmployee, DisplayClient displayClient,
                          DisplayEmployee displayEmployee, EditEmployeeById editEmployeeById,
                          RemoveClientById removeClientById, RemoveEmployeeById removeEmployeeById,
                          SearchClientById searchClientById, SearchEmployeeById searchEmployeeById,
                          SortClientByName sortClientByName, SortEmployeeBySalary sortEmployeeBySalary,
                          TotalRevenue totalRevenue, TotalSalary totalSalary) {
        this.addNewClient = addNewClient;
        this.addNewEmployee = addNewEmployee;
        this.displayClient = displayClient;
        this.displayEmployee = displayEmployee;
        this.editEmployeeById = editEmployeeById;
        this.removeClientById = removeClientById;
        this.removeEmployeeById = removeEmployeeById;
        this.searchClientById = searchClientById;
        this.searchEmployeeById = searchEmployeeById;
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
    public void editEmployeeById(String inputID, Employee employee) {
        editEmployeeById.execute(inputID, employee);
    }
    public void removeEmployeeById(String inputID) {
        removeEmployeeById.execute(inputID);
    }
    public void removeClientById(String inputID) {
        removeClientById.execute(inputID);
    }
    public List<Employee> sortEmployeeBySalary(){
        return sortEmployeeBySalary.execute();
    }
    public List<Client> sortClientByName() {
        return sortClientByName.execute();
    }
    public void displayClient() {
        displayClient.execute();
    }
    public void displayEmployee() {
        displayEmployee.execute();
    }
    public String totalSalary(){
        return totalSalary.execute();
    }
    public String totalRevenue(){
        return totalRevenue.execute();
    }
    public void searchEmployeeById(String inputID){
        searchEmployeeById.execute(inputID);
    }
    public void searchClientById(String inputID){
        searchClientById.execute(inputID);
    }
}
