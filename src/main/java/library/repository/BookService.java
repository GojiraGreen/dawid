package library.repository;

import library.entity.LibraryBook;

import java.util.List;

/**
 * @author azielinski1
 */
public interface BookService {
    void saveBook(LibraryBook book);

    void deleteBook(long id);

    List<LibraryBook> getBooks();

    void getBook(long id);

    void writeBooksToFile(String path);

    void readBooksFromFile(String s);
}
