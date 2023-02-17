package concreteCommand;

import command.CommandVoidWithParameters;
import controller.LibraryManager;

public class SearchClientById implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public SearchClientById() {
    }

    public SearchClientById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(String inputID) {
        libraryManager.searchClientById(inputID);
    }
}
