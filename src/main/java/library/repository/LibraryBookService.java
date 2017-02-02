package library.repository;

import library.entity.LibraryBook;
import library.entity.LibraryDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author azielinski1
 */
public class LibraryBookService implements BookService {

    LibraryDatabase database;

    public LibraryBookService() {
        this.database = LibraryDatabase.getInstance();
    }

    @Override
    public void saveBook(LibraryBook book) {
        this.database.addBook(book);
    }

    @Override
    public void deleteBook(long id) {

    }

    @Override
    public List<LibraryBook> getBooks() {
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
            System.out.println("Błąd wczytania danych z wejścia." + exc.getMessage());
        } catch (JAXBException exc) {
            System.out.println("Błąd zapisu danych do pliku." + exc.getMessage());
        }
    }

    @Override
    public void readBooksFromFile(String path) {
        try {

            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(LibraryDatabase.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.database = (LibraryDatabase) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException exc) {
            System.out.println("Błąd wczytania danych z pliku." + exc.getMessage());
        }
    }
}
