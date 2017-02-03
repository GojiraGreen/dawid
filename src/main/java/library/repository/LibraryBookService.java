package library.repository;

import library.entity.LibraryBook;
import library.entity.LibraryDatabase;
import library.enums.Columns;
import library.printers.LibraryPrinter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Dawid Wąs
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
        this.database.removeBook(id);
    }

    @Override
    public void printBooks() {
        LibraryPrinter.printBookList(database.getBooks());
    }

    @Override
    public void sortBooks(String column) {
        List<LibraryBook> sortedBooks = this.database.getBooks();
        switch(column) {
            case Columns.ID:
                Collections.sort(sortedBooks, Comparator.comparing(LibraryBook::getId));
                break;
            case Columns.AUTHOR:
                Collections.sort(sortedBooks, Comparator.comparing(LibraryBook::getAuthor));
                break;
            case Columns.TITLE:
                Collections.sort(sortedBooks, Comparator.comparing(LibraryBook::getTitle));
                break;
            case Columns.CATEGORY:
                Collections.sort(sortedBooks, Comparator.comparing(LibraryBook::getCategory));
                break;
            case Columns.LOCALIZATION:
                Collections.sort(sortedBooks, Comparator.comparing(LibraryBook::getLocalization));
                break;
            case Columns.REMARKS:
                Collections.sort(sortedBooks, Comparator.comparing(LibraryBook::getRemarks));
                break;
        }
        LibraryPrinter.printBookList(sortedBooks);
    }

    /**
     * 1"autor" 2"tytuł" 3"lokalizacja" 4"kategoria"
     *
     * @param columns
     */
    public void printFilteredBooks(String[] columns) {
        List<LibraryBook> filteredBooks = new ArrayList<>();

        if (columns.length == 2) {
            filteredBooks = (List<LibraryBook>) filteredBooks.stream().filter(b -> b.getAuthor() == columns[1]);
        }

        if (columns.length == 3) {
            filteredBooks = (List<LibraryBook>) filteredBooks.stream().filter(b -> b.getTitle() == columns[2]);
        }

        if (columns.length == 4) {
            filteredBooks = (List<LibraryBook>) filteredBooks.stream().filter(b -> b.getLocalization() == columns[3]);
        }

        if (columns.length == 5) {
            filteredBooks = (List<LibraryBook>) filteredBooks.stream().filter(b -> b.getCategory() == columns[4]);
        }

        LibraryPrinter.printBookList(filteredBooks);
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
