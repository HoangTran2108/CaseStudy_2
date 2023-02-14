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
        try {
            File file = new File("employee.dat");
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

    public List<Employee> readFileEmployee() throws IOException, ClassNotFoundException {
        File file = new File("employee.dat");
        List<Employee> employees;
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            employees = (List<Employee>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
    public void writeFileClient(List<Client> clients) {
        try {
            File file = new File("client.dat");
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(clients);
            fos.close();
            os.close();
        }
        catch (Exception e) {
            System.out.println("Lỗi");
        }
    }

    public List<Client> readFileClient() throws IOException, ClassNotFoundException {
        File file = new File("client.dat");
        List<Client> clients;
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            clients = (List<Client>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
}