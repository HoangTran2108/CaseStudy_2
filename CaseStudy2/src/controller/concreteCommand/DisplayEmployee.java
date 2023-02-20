package controller.concreteCommand;

import controller.command.CommandVoid;
import controller.LibraryManager;

public class DisplayEmployee implements CommandVoid {
    LibraryManager libraryManager;

    public DisplayEmployee(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute() {
        libraryManager.displayEmployee();
    }
}
