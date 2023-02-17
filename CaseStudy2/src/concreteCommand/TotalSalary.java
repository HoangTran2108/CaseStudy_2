package concreteCommand;

import command.CommandString;
import controller.LibraryManager;

public class TotalSalary implements CommandString {
    LibraryManager libraryManager;

    public TotalSalary() {
    }

    public TotalSalary(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public String execute() {
        return libraryManager.totalSalary();
    }
}
