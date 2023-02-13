package storage;

import model.Client;
import model.Employee;
import model.Person;

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

    public boolean writeFileEmployee(List<Employee> employees) throws IOException {
        File file = new File("employee.dat");
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream fos = new ObjectOutputStream(os);
        fos.writeObject(employees);
        fos.close();
        os.close();
        return true;
    }

    public List<Client> readFileEmployee()  {
        File file = new File("employee.dat");
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (objectInputStream != null) {

                List<Client> list;
                try {
                    list = (List<Client>) objectInputStream.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                return list;
            }
            else {
                return new ArrayList<>();
            }
        }

    }
    public boolean writeFileClient(List<Client> clients) throws IOException {
        File file = new File("client.dat");
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream fos = new ObjectOutputStream(os);
        fos.writeObject(clients);
        fos.close();
        os.close();
        return true;
    }

    public List<Client> readFileClient()  {
        File file = new File("client.dat");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (objectInputStream != null) {

                List<Client> list;
                try {
                    list = (List<Client>) objectInputStream.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                return list;
            }
            else {
                return new ArrayList<>();
            }
        }

    }
}