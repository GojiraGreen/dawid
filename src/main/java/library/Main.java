package library;

import library.enums.Commands;

import java.text.NumberFormat;
import java.util.Scanner;

import static library.enums.Commands.*;

/**
 * @author azielinski1
 */
public class Main {
    public static void main(String[] args){

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        // Obiekt pozwalający na wczytanie informacji z wejścia
        Scanner sc = new Scanner(System.in);

        // kontrola sesji konsoli
        boolean session = true;

        while (session) {

            // Menu dla użytkownika programu

            System.out.print("\nWitaj w bibiotece:\n\n"
                    + "Dodanie książki\n"
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

            // Wczytanie wartości z wejścia
            String input = sc.nextLine();

            String[] selection = input.split(";");
            String prefix = selection[0];

            // Switch obsługujący wybór opcji użytkownika
            switch (prefix) {

                case Commands.ADD:
                    break;
                case Commands.DELETE:
                    break;
                case Commands.LIST:
                    break;
                case Commands.LIST_FILTER:
                    break;
                case Commands.LIST_SORT:
                    break;
                case Commands.READ:
                    break;
                case Commands.WRITE:
                    break;
                case Commands.QUIT:
                    break;
                default:
                    System.out.println("Wprowadzone polecenie nie jest prawidłowe.");
            }

        }

        System.out.println("\nThank you for banking with us!\n");

    }
}
