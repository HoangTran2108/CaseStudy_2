package concreteCommand;

import command.CommandAddBook;
import controller.LibraryManager;
import model.Book;

public class AddNewBook implements CommandAddBook {
    LibraryManager libraryManager;

    public AddNewBook(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(Book book) {
        libraryManager.addNewBook(book);
    }
}