package controller.concreteCommand;

import controller.command.CommandVoid;
import controller.LibraryManager;

public class SortClientByName implements CommandVoid {
    LibraryManager libraryManager;

    public SortClientByName(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute() {
        libraryManager.sortClientByName();
    }
}
