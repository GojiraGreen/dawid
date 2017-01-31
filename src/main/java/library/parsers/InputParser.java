package library.parsers;
import library.entity.Book;
import library.entity.LibraryBook;

import java.time.LocalDate;

/**
 * @author azielinski1
 */
public class InputParser {
    public static Book parseBook(String[] selection) {
        Book book = new LibraryBook();
        book.setId(System.currentTimeMillis());
        book.setAuthor(selection[1]);
        book.setTitle(selection[2]);
        book.setLocalization(selection[3]);
        book.setCategory(selection[4]);
        book.setRemarks(selection[5]);
        return book;
    }
}
