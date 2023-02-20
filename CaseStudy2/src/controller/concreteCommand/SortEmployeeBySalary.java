package controller.concreteCommand;

import controller.command.CommandVoid;
import controller.LibraryManager;

public class SortEmployeeBySalary implements CommandVoid {
    LibraryManager libraryManager;

    public SortEmployeeBySalary(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute() {
        libraryManager.sortEmployeeBySalary();
    }
}
