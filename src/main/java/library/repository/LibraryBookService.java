package library.repository;

import library.entity.Book;
import library.entity.LibraryDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author azielinski1
 */
public class LibraryBookService implements BookService{

    LibraryDatabase database;

    public LibraryBookService(){
        this.database = LibraryDatabase.getInstance();
    }

    @Override
    public void saveBook(Book book) {
        this.database.addBook(book);
    }

    @Override
    public void deleteBook(long id) {

    }

    @Override
    public List<Book> getBooks() {
        return database.getBooks();
    }

    @Override
    public void getBook(long id) {

    }

    @Override
    public void writeBooksToFile(String path) {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(path);
            JAXBContext ctx = JAXBContext.newInstance(LibraryDatabase.class);
            Marshaller ma = ctx.createMarshaller();
            ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ma.marshal(this.database, file);
        } catch (IOException exc) {
            System.out.println("Błąd wczytania danych z wejścia.");
        } catch (JAXBException exc) {
            System.out.println("Błąd zapisu danych do pliku.");
        }
    }
}
