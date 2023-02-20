package controller.concreteCommand;

import controller.command.CommandVoidWithParameters;
import controller.LibraryManager;

public class RemoveBookByName implements CommandVoidWithParameters {
    LibraryManager libraryManager;

    public RemoveBookByName(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public String execute(String name) {
        return libraryManager.removeBookByName(name);
    }
}