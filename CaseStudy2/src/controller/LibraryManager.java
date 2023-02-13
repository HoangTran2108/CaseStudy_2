package controller;

import model.Person;
import storage.ReadAndWrite;

import java.io.IOException;
import java.util.List;

public class LibraryManager {
    List<Person> personList;

    public LibraryManager() {
    }

    public LibraryManager(List<Person> personList) {
        this.personList = personList;
    }
    public void addNewPerson(Person person){
        personList.add(person);
        try {
            ReadAndWrite.getInstance().writeFile(personList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Person> removePerson(String inputID){
        for (Person person: personList) {
            if(inputID.equals(person.getId())){
                personList.remove(person);
            }
        }
        return personList;
    }
}