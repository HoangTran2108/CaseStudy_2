package controller.concreteCommand;

import controller.command.CommandString;
import controller.LibraryManager;

public class TotalRevenue implements CommandString {
    LibraryManager libraryManager;

    public TotalRevenue(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public String execute() {
        return libraryManager.totalRevenue();
    }
}
