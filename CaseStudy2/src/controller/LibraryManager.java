package controller;

import model.Client;
import model.Employee;
import storage.ReadAndWrite;

import java.util.Collections;
import java.util.List;

public class LibraryManager {
    List<Client>clientList;
    List<Employee>employeeList;

    public LibraryManager() {
        clientList = ReadAndWrite.getInstance().readFileClient();
        employeeList = ReadAndWrite.getInstance().readFileEmployee();
    }

    public LibraryManager(List<Client> clientList, List<Employee> employeeList) {
        this.clientList = clientList;
        this.employeeList = employeeList;
    }

    public void addNewEmployee(Employee employee) {
        employeeList.add(employee);
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }
    public void addNewClient(Client client) {
        clientList.add(client);
        ReadAndWrite.getInstance().writeFileClient(clientList);
    }
    public void editEmployeeById(String inputID, Employee employee) {
        for (int i =0; i < employeeList.size(); i++) {
            if(inputID.equals(employeeList.get(i).getId())){
                employeeList.set(i, employeeList.get(i));
                break;
            } else {
                System.out.println("Không tìm thấy id vừa nhập");
            }
        }
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }
    public void removeEmployeeById(String inputID) {
        for (Employee employee: employeeList) {
            if(inputID.equals(employee.getId())){
                employeeList.remove(employee);
                break;
            } else {
                System.out.println("Không tìm thấy id vừa nhập.");
            }
        }
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }
    public void removeClientById(String inputID) {
        for (Client client: clientList) {
            if(inputID.equals(client.getId())){
                clientList.remove(client);
                break;
            } else {
                System.out.println("Không tìm thấy id vừa nhập.");
            }
        }
        ReadAndWrite.getInstance().writeFileClient(clientList);
    }
    public List<Employee> sortEmployeeBySalary(){
        Collections.sort(employeeList);
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
        return employeeList;
    }
    public List<Client> sortClientByName() {
        Collections.sort(clientList);
        ReadAndWrite.getInstance().writeFileClient(clientList);
        return clientList;
    }
    public void displayClient() {
        for (Client client: clientList) {
            System.out.println(client);
        }
    }
    public void displayEmployee() {
        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
    }
    public String totalSalary(){
        StringBuilder stringBuilder = new StringBuilder();
        double sumSalary = 0;
        for (Employee employee: employeeList) {
            sumSalary += employee.totalMoney();
        }
        stringBuilder.append("Tổng tiền phải trả cho tất cả nhân viên là: ").append(sumSalary);
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
    public void searchEmployeeById(String inputID){
        for (Employee employee: employeeList) {
            if(inputID.equals(employee.getId())){
                System.out.println(employee);
            }
        }
    }
    public void searchClientById(String inputID){
        for (Client client: clientList) {
            if(inputID.equals(client.getId())){
                System.out.println(client);
            }
        }
    }

}