package concreteCommand;

import command.CommandAddEmployee;
import controller.LibraryManager;
import model.Employee;

public class AddNewEmployee implements CommandAddEmployee {
    LibraryManager libraryManager;

    public AddNewEmployee(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(Employee employee) {
        libraryManager.addNewEmployee(employee);
    }
}
