package storage;

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

    public boolean writeFile(List<Person> materials) throws IOException {
        File file = new File("preson.dat");
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream fos = new ObjectOutputStream(os);
        fos.writeObject(materials);
        fos.close();
        os.close();
        return true;
    }

    public List<Person> readFile()  {
        File file = new File("person.dat");
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

                List<Person> list = null;
                try {
                    list = (List<Person>) objectInputStream.readObject();
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