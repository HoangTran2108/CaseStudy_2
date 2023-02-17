package conCreteCommand;

import command.CommandSearch;
import controller.LibraryManager;

public class SearchEmployeeById implements CommandSearch {
    LibraryManager libraryManager;

    @Override
    public void execute(String inputID) {
        libraryManager.searchEmployeeById(inputID);
    }
}
