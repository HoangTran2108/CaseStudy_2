package controller.concreteCommand;

import controller.command.CommandVoidWithParameters;
import controller.LibraryManager;

public class SearchEmployeeById implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public SearchEmployeeById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public String execute(String inputID) {
        return libraryManager.searchEmployeeById(inputID);
    }
}
