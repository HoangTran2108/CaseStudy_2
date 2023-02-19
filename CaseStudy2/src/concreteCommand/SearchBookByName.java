package concreteCommand;

import command.CommandSearchBook;
import controller.LibraryManager;
import model.Book;

public class SearchBookByName implements CommandSearchBook {
    LibraryManager libraryManager;

    public SearchBookByName(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public Book execute(String name) {
        return libraryManager.searchBookByName(name);
    }
}
