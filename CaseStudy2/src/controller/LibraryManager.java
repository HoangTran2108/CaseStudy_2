package controller;

import model.Client;
import model.Employee;
import storage.ReadAndWrite;

import java.util.Collections;
import java.util.List;

public class LibraryManager {
    private final List<Client>clientList;
    private final List<Employee>employeeList;

    public LibraryManager() {
        clientList = ReadAndWrite.getInstance().readFileClient();
        employeeList = ReadAndWrite.getInstance().readFileEmployee();
    }

    public List<Client> getClientList(){
        return clientList;
    }
    public List<Employee> getEmployeeList(){
        return employeeList;
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
                employeeList.set(i, employee);
                break;
            }
        }
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }
    public String removeEmployeeById(String inputID) {
        for (Employee employee: employeeList) {
            if(inputID.equals(employee.getId())){
                employeeList.remove(employee);
                ReadAndWrite.getInstance().writeFileEmployee(employeeList);
                return "Xóa thành công";
            }
        }
        return "Không tìm thấy id";
    }
    public String removeClientById(String inputID) {
        for (Client client: clientList) {
            if(inputID.equals(client.getId())){
                clientList.remove(client);
                ReadAndWrite.getInstance().writeFileClient(clientList);
                return "xóa thành công";
            }
        }
        return "Không tìm thấy id";
    }
    public void sortEmployeeBySalary(){
        Collections.sort(employeeList);
        ReadAndWrite.getInstance().writeFileEmployee(employeeList);
    }
    public void sortClientByName() {
        Collections.sort(clientList);
        ReadAndWrite.getInstance().writeFileClient(clientList);
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
    public String searchEmployeeById(String inputID){
        for (Employee employee: employeeList) {
            if(inputID.equals(employee.getId())){
                return employee.toString();
            }
        }
        return "Không tìm thấy id";
    }
    public String searchClientById(String inputID){
        for (Client client: clientList) {
            if(inputID.equals(client.getId())){
                return client.toString();
            }
        }
        return "Không tìm thấy id";
    }

}