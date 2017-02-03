package library.printers;

import library.entity.LibraryBook;

import java.util.List;

/**
 * Created by Aron on 2017-02-03.
 */
public class LibraryPrinter implements Printer {

    public static void printBookList(List<LibraryBook> books) {
        books.stream().forEach(Printer::printBook);
    }


}
