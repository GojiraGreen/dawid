package library.entity;

import java.util.List;

/**
 * @author Dawid Wąs
 */
public interface Database {
    List<LibraryBook> getBooks();
    void removeBook(long id);
    void addBook(LibraryBook book);
}
