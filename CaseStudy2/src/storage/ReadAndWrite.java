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
        try {
            File file = new File("employee.dat");
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
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = null;
            objectInputStream = new ObjectInputStream(inputStream);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void writeFileClient(List<Client> clients) throws IOException {
        File file = new File("client.dat");
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream fos = new ObjectOutputStream(os);
        fos.writeObject(clients);
        fos.close();
        os.close();
    }

    public List<Client> readFileClient()  {
        File file = new File("client.dat");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = null;
            objectInputStream = new ObjectInputStream(inputStream);
        }
            catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}