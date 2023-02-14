package controller;

import model.Client;
import model.Employee;
import storage.ReadAndWrite;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class LibraryManager {
    List<Client>clientList = ReadAndWrite.getInstance().readFileClient();
    List<Employee>employeeList = ReadAndWrite.getInstance().readFileEmployee();

    public LibraryManager() {
    }

    public LibraryManager(List<Client> clientList, List<Employee> employeeList) {
        this.clientList = clientList;
        this.employeeList = employeeList;
    }

    public void addNewEmployee(Employee employee) throws IOException {
        employeeList.add(employee);
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }
    public void addNewClient(Client client) throws IOException {
        clientList.add(client);
        ReadAndWrite.getInstance().writeFileClient(clientList);
    }
    public List<Employee> removeEmployeeById(String inputID) throws IOException {
        for (Employee employee: employeeList) {
            if(inputID.equals(employee.getId())){
                employeeList.remove(employee);
                ReadAndWrite.getInstance().writeFileEmployee(employeeList);
            }
        }
        return employeeList;
    }
    public List<Client> removeClientById(String inputID) throws IOException {
        for (Client client: clientList) {
            if(inputID.equals(client.getId())){
                clientList.remove(client);
                ReadAndWrite.getInstance().writeFileClient(clientList);
            }
        }
        return clientList;
    }
    public List<Employee> sortEmployeeBySalary() throws IOException {
        Collections.sort(employeeList);
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
        return employeeList;
    }
    public List<Client> sortClientByName() throws IOException {
        Collections.sort(clientList);
        ReadAndWrite.getInstance().writeFileClient(clientList);
        return clientList;
    }
    public String totalSalary(){
        StringBuilder stringBuilder = new StringBuilder();
        double sumSalary = 0;
        for (Employee employee: employeeList) {
            sumSalary += employee.totalMoney();
        }
        stringBuilder.append("Tổng tiền phải trả cho nhân viên là: ").append(sumSalary);
        return stringBuilder.toString();
    }
    public String totalRevenue(){
        StringBuilder stringBuilder = new StringBuilder();
        double sumRevenue = 0;
        for (Client client: clientList) {
            sumRevenue += client.totalMoney();
        }
        stringBuilder.append("Tổng tiền dự kiến thu được từ phiếu mượn sách: ").append(sumRevenue);
        return stringBuilder.toString();
    }
    public Employee searchEmployeeById(String inputID){
        for (Employee employee: employeeList) {
            if(inputID.equals(employee.getId())){
                return employee;
            }
        }
        return null;
    }
    public Client searchClientById(String inputID){
        for (Client client: clientList) {
            if(inputID.equals(client.getId())){
                return client;
            }
        }
        return null;
    }

}