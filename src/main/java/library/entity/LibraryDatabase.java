package library.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author azielinski1
 */
@XmlRootElement
public class LibraryDatabase implements Database{

    @XmlElementWrapper(name="books")
    @XmlElement(name="book")
    List<Book> books;

    private static LibraryDatabase instance = null;

    protected LibraryDatabase() {
        this.books = new ArrayList<>();
    }
    public static LibraryDatabase getInstance() {
        if(instance == null) {
            instance = new LibraryDatabase();
        }
        return instance;
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public void setBooks(List<Book> records) {

    }

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }
}
