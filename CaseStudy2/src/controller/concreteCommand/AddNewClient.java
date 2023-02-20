package controller.concreteCommand;

import controller.command.CommandAddClient;
import controller.LibraryManager;
import model.Client;

public class AddNewClient implements CommandAddClient {
    LibraryManager libraryManager;

    public AddNewClient(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(Client client) {
        libraryManager.addNewClient(client);
    }
}
