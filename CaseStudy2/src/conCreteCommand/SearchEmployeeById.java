package conCreteCommand;

import command.CommandVoidWithParameters;
import controller.LibraryManager;

public class SearchEmployeeById implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public SearchEmployeeById() {
    }

    public SearchEmployeeById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(String inputID) {
        libraryManager.searchEmployeeById(inputID);
    }
}
