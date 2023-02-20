package controller.concreteCommand;

import controller.command.CommandVoid;
import controller.LibraryManager;

public class DisplayBook implements CommandVoid {
    LibraryManager libraryManager;

    public DisplayBook(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute() {
        libraryManager.displayBook();
    }
}
