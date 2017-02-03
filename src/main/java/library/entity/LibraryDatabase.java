package library.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dawid Wąs
 */
@XmlRootElement(name="books")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryDatabase implements Database{

//    @XmlElementWrapper(name="books")
    @XmlElement(name="book")
    List<LibraryBook> books;

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
    public List<LibraryBook> getBooks() {
        return null;
    }

    @Override
    public void removeBook(long id) {
        this.books.remove(this.books.stream().filter(b -> b.getId() == id).findFirst());
    }


    @Override
    public void addBook(LibraryBook book) {
        this.books.add(book);
    }
}
