package library.repository;

import library.entity.LibraryBook;

import java.util.List;

/**
 * @author Dawid Wąs
 */
public interface BookService {
    void saveBook(LibraryBook book);

    void deleteBook(long id);

    void printBooks();

    void writeBooksToFile(String path);

    void readBooksFromFile(String s);

    void sortBooks(String s);
}
