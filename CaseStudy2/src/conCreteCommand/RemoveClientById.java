package conCreteCommand;

import command.CommandVoidWithParameters;
import controller.LibraryManager;

public class RemoveClientById implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public RemoveClientById() {
    }

    public RemoveClientById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(String inputID) {
        libraryManager.removeClientById(inputID);
    }
}
