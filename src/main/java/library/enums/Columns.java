package library.enums;

/**
 * @author azielinski1
 */


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

public class Columns {

    public final static String AUTHOR = "autor";
    public final static String TITLE = "tytuł";
    public final static String LOCALIZATION = "lokalizacja";
    public final static String CATEGORY = "kategoria";
    public final static String ADD = "autor";
    public final static String ADD = "autor";

}
