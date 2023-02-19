package command;

import model.Book;

public interface CommandSearchBook {
    Book execute(String name);
}
