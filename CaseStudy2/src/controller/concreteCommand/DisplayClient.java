package controller.concreteCommand;

import controller.command.CommandVoid;
import controller.LibraryManager;

public class DisplayClient implements CommandVoid {
    LibraryManager libraryManager;

    public DisplayClient(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute() {
        libraryManager.displayClient();
    }
}
