package concreteCommand;

import command.CommandListClient;
import controller.LibraryManager;
import model.Client;

import java.util.List;

public class SortClientByName implements CommandListClient {
    LibraryManager libraryManager;

    public SortClientByName() {
    }

    public SortClientByName(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public List<Client> execute() {
        return libraryManager.sortClientByName();
    }
}
