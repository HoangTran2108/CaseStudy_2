package storage;

import model.Client;
import model.Employee;
import model.Login;

import java.util.List;

public interface IReadWriteFile {
    void writeFileEmployee(List<Employee>employees);
    List<Employee>readFileEmployee();
    void writeFileClient(List<Client>clients);
    List<Client>readFileClient();
    void writeFileLogin(List<Login>logins);
    List<Login>readFileLogin();
    void writeFileLoginManager(List<Login>logins);
    List<Login>readFileLoginManager();
}
