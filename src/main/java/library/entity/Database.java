package library.entity;

import java.util.List;

/**
 * @author azielinski1
 */
public interface Database {
    List<Book> getBooks();
    void setBooks(List<Book> records);
    void addBook(Book book);
}
