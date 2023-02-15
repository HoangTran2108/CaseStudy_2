package storage;

import model.Client;
import model.Employee;
import model.Login;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadAndWrite implements IReadWriteFile {

    private ReadAndWrite() {
    }

    private static ReadAndWrite instance;

    public static ReadAndWrite getInstance() {
        if (instance == null) instance = new ReadAndWrite();
        return instance;
    }

    @Override
    public void writeFileEmployee(List<Employee> employees) {
        File file = new File("employee.dat");
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(employees);
            fos.close();
            os.close();
        } catch (Exception e) {
            System.err.println("Lỗi ghi file");
        }
    }

    @Override
    public List<Employee> readFileEmployee() {
        File file = new File("employee.dat");
        List<Employee> employees = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(stream);
            employees = (List<Employee>) ois.readObject();
            ois.close();
            stream.close();
        } catch (Exception e) {
            System.err.println("Lỗi đọc file");
        }
        return employees;
    }

    @Override
    public void writeFileClient(List<Client> clients) {
        try {
            File file = new File("client.dat");
            FileOutputStream os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(clients);
            fos.close();
            os.close();
        } catch (Exception e) {
            System.err.println("Lỗi ghi file");
        }
    }

    @Override
    public List<Client> readFileClient() {
        File file = new File("client.dat");
        List<Client> clients = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(stream);
            clients = (List<Client>) ois.readObject();
            ois.close();
            stream.close();
        } catch (Exception e) {
            System.err.println("Lỗi đọc file");
        }
        return clients;
    }
    @Override
    public void writeFileLogin(List<Login> logins) {
        try {
            File file = new File("login.dat");
            FileOutputStream os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(logins);
            fos.close();
            os.close();
        } catch (Exception e) {
            System.err.println("Lỗi ghi file");
        }
    }

    @Override
    public List<Login> readFileLogin() {
        File file = new File("login.dat");
        List<Login> logins = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(stream);
            logins = (List<Login>) ois.readObject();
            ois.close();
            stream.close();
        } catch (Exception e) {
            System.err.println("Lỗi đọc file");
        }
        return logins;
    }
    @Override
    public void writeFileLoginManager(List<Login> logins) {
        try {
            File file = new File("loginManager.dat");
            FileOutputStream os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(logins);
            fos.close();
            os.close();
        } catch (Exception e) {
            System.err.println("Lỗi ghi file");
        }
    }

    @Override
    public List<Login> readFileLoginManager() {
        File file = new File("loginManager.dat");
        List<Login> logins = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(stream);
            logins = (List<Login>) ois.readObject();
            ois.close();
            stream.close();
        } catch (Exception e) {
            System.err.println("Lỗi đọc file");
        }
        return logins;
    }
}