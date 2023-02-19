package command;

import model.Book;

public interface CommandAddBook {
    void execute(Book book);
}