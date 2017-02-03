package library.console;

import library.enums.Commands;
import library.parsers.InputParser;
import library.repository.LibraryBookService;

import java.util.Scanner;

import static library.printers.Printer.*;

/**
 * @author Dawid Wąs
 */
public class ConsoleAppSetup implements Console {

    public static void setupApplication() {

        LibraryBookService libraryBookService = new LibraryBookService();

        // Obiekt pozwalający na wczytanie informacji z wejścia
        Scanner sc = new Scanner(System.in);

        // kontrola sesji konsoli
        boolean session = true;

        printWelcome();

        while (session) {

            // Menu dla użytkownika programu
            printMenu();

            // Wczytanie wartości z wejścia
            String input = sc.nextLine();

            String[] selection = input.split(";");
            String prefix = selection[0];

            // Switch obsługujący wybór opcji użytkownika
            switch (prefix) {

                case Commands.ADD:
                    libraryBookService.saveBook(InputParser.parseBook(selection));
                    break;
                case Commands.DELETE:
                    libraryBookService.deleteBook(Long.parseLong(selection[1]));
                    break;
                case Commands.LIST:
                    libraryBookService.printBooks();
                    break;
                case Commands.LIST_FILTER:
                    libraryBookService.printFilteredBooks(selection);
                    break;
                case Commands.LIST_SORT:
                    libraryBookService.sortBooks(selection[1]);
                    break;
                case Commands.READ:
                    libraryBookService.readBooksFromFile(selection[1]);
                    break;
                case Commands.WRITE:
                    libraryBookService.writeBooksToFile(selection[1]);
                    break;
                case Commands.QUIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wprowadzone polecenie nie jest prawidłowe.");
            }

        }
        printGoodBye();
    }
}
