package library.repository;

import library.entity.Book;

import java.util.List;

/**
 * @author azielinski1
 */
public interface BookService {
    void saveBook(Book book);
    void deleteBook(long id);
    List<Book> getBooks();
    void getBook(long id);
    void writeBooksToFile(String path);
}
