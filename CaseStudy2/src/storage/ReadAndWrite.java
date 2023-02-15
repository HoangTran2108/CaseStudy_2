package storage;

import model.Client;
import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadAndWrite {

    public ReadAndWrite() {
    }

    private static ReadAndWrite instance;

    public static ReadAndWrite getInstance(){
        if (instance == null) instance = new ReadAndWrite();
        return instance;
    }

    public void writeFileEmployee(List<Employee> employees){
        File file = new File("employee.dat");
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(employees);
            fos.close();
            os.close();
        }
        catch (Exception e){
            System.out.println("Lỗi");
        }
    }

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
            System.err.println("Lỗi");
        }
        return employees;
    }
    public void writeFileClient(List<Client> clients) {
        try {
            File file = new File("client.dat");
            FileOutputStream os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(clients);
            fos.close();
            os.close();
        }
        catch (Exception e) {
            System.out.println("Lỗi");
        }
    }

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
            System.err.println("Lỗi");
        }
        return clients;
    }
}