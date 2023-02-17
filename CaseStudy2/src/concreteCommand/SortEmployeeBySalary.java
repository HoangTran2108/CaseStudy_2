package concreteCommand;

import command.CommandListEmployee;
import controller.LibraryManager;
import model.Employee;

import java.util.List;

public class SortEmployeeBySalary implements CommandListEmployee {
    LibraryManager libraryManager;

    public SortEmployeeBySalary() {
    }

    public SortEmployeeBySalary(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public List<Employee> execute() {
        return libraryManager.sortEmployeeBySalary();
    }
}
