package controller;

import model.Client;
import model.Employee;
import storage.ReadAndWrite;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class LibraryManager {
    List<Client>clientList;
    List<Employee>employeeList;

    public LibraryManager() {
    }

    public LibraryManager(List<Client> clientList, List<Employee> employeeList) {
        this.clientList = clientList;
        this.employeeList = employeeList;
    }

    public void addNewClient(Client client) throws IOException {
        clientList.add(client);
        ReadAndWrite.getInstance().writeFileClient(clientList);
    }
    public void addNewEmployee(Employee employee) throws IOException {
        employeeList.add(employee);
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }
    public List<Employee> removeEmployeeById(String inputID){
        for (Employee employee: employeeList) {
            if(inputID.equals(employee.getId())){
                employeeList.remove(employee);
            }
        }
        return employeeList;
    }
    public List<Client> removeClientById(String inputID){
        for (Client client: clientList) {
            if(inputID.equals(client.getId())){
                clientList.remove(client);
            }
        }
        return clientList;
    }
    public List<Employee> sortEmployeeBySalary() {
        Collections.sort(employeeList);
        return employeeList;
    }
    public List<Client> sortClientByName() {
        Collections.sort(clientList);
        return clientList;
    }
}