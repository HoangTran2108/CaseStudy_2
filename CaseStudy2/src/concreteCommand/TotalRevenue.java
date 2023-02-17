package concreteCommand;

import command.CommandString;
import controller.LibraryManager;

public class TotalRevenue implements CommandString {
    LibraryManager libraryManager;

    public TotalRevenue() {
    }

    public TotalRevenue(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public String execute() {
        return libraryManager.totalRevenue();
    }
}
