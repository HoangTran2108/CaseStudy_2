package conCreteCommand;

import command.CommandSearch;
import controller.LibraryManager;

public class SearchClientById implements CommandSearch {
    LibraryManager libraryManager;

    public SearchClientById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(String inputID) {
        libraryManager.searchClientById(inputID);
    }
}
