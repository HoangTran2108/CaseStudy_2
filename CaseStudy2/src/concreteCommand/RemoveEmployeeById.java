package concreteCommand;

import command.CommandVoidWithParameters;
import controller.LibraryManager;

public class RemoveEmployeeById implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public RemoveEmployeeById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public String execute(String inputID) {
        return libraryManager.removeEmployeeById(inputID);
    }
}
