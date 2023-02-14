package storage;

import model.Client;
import model.Employee;

import java.io.*;
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
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Employee> readFileEmployee()  {
        File file = new File("employee.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            List<Employee> employees = (List<Employee>)ois.readObject();
            ois.close();
            fileInputStream.close();
            return employees;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeFileClient(List<Client> clients) throws IOException {
        File file = new File("client.dat");
        OutputStream os;
        try {
            os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(clients);
            fos.close();
            os.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Client> readFileClient()  {
        File file = new File("client.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            List<Client> clients = (List<Client>)ois.readObject();
            ois.close();
            fileInputStream.close();
            return clients;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}