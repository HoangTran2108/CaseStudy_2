package conCreteCommand;

import command.CommandVoidWithParameters;
import controller.LibraryManager;

public class RemoveEmployeeById implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public RemoveEmployeeById() {
    }

    public RemoveEmployeeById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(String inputID) {
        libraryManager.removeEmployeeById(inputID);
    }
}
