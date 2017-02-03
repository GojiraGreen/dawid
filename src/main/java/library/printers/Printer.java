package library.printers;

import library.entity.LibraryBook;
import library.enums.Commands;

import java.util.List;

/**
 * Created by Aron on 2017-02-03.
 */
public interface Printer {
    static void printBook(LibraryBook book){
        System.out.println("book: " +
                book.getId() + ";" +
                book.getAuthor() + ";" +
                book.getTitle() + ";" +
                book.getCategory() + ";" +
                book.getLocalization() + ";" +
                book.getRemarks() + ";");
    }

    static void printBookList(List<LibraryBook> books){}

    static void printMenu() {
        System.out.print("Dodanie książki\n"
                + Commands.ADD + ";<autor>;<tytuł>;<lokalizacja>;<kategoria>;<uwagi>\n\n"
                + "Usunięcie książki\n"
                + Commands.DELETE + ";<id>\n\n"
                + "Lista książek\n"
                + Commands.LIST + "L\n\n"
                + "Lista książek po zastosowaniu filtra\n"
                + Commands.LIST_FILTER + ";[<autor>];[<tytuł>];[<lok>];[<kat>]\n\n"
                + "Lista książek sortowana po kolumnie:\n"
                + Commands.LIST_SORT + ";<kolumna>\n\n"
                + "Zapis do pliku xlsx?\n"
                + Commands.WRITE + ";<ścieżka do pliku>\n\n"
                + "Odczyt z pliku xml.\n"
                + Commands.READ + ";<ścieżka do pliku>\n\n"
                + "Zakończenie pracy\n"
                + "QUIT"
                + "Wprowadz polecenie: \n\n");
    }

    static void printWelcome(){
        System.out.print("\nWitaj w bibiotece:\n\n");
    };

    static void printGoodBye(){
        System.out.println("\nThank you for using our application!\n");
    }
}
