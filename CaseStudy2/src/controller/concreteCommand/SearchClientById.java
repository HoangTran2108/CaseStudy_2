package controller.concreteCommand;

import controller.command.CommandVoidWithParameters;
import controller.LibraryManager;

public class SearchClientById implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public SearchClientById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public String execute(String inputID) {
        return libraryManager.searchClientById(inputID);
    }
}
