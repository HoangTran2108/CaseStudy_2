package concreteCommand;

import command.CommandVoidWithParameters;
import controller.LibraryManager;

public class RemoveClientById implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public RemoveClientById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public String execute(String inputID) {
        return libraryManager.removeClientById(inputID);
    }
}
