package library.parsers;
import library.entity.LibraryBook;

/**
 * @author Dawid Wąs
 */
public class InputParser {
    public static LibraryBook parseBook(String[] selection) {
        LibraryBook book = new LibraryBook();
        book.setId(System.currentTimeMillis());
        book.setAuthor(selection[1]);
        book.setTitle(selection[2]);
        book.setLocalization(selection[3]);
        book.setCategory(selection[4]);
        book.setRemarks(selection[5]);
        return book;
    }
}
