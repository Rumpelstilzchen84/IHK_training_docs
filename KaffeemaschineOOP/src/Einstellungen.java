import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author: Philip Kottmann
 * @Datum: 7.4.2025
 * @Inhalt: Einstellungen der Kaffeemaschine anzeigen und ändern
 */

public class Einstellungen {
    private static int einstellungenAuswahl;
    private static String[] menu;

    // TODO: Brauch ich das? => Schau'n mer mal!
//    private String bezeichnung;
//    private int fuellmenge;
//    private int bruehzeit;
//    private boolean milchschaum;
//    private BigDecimal preis;

    // leerer Konstruktor der verhindert, dass eine Instanz erstellt wird.
    private Einstellungen(){
    }

    public static void setEinstellungenAuswahl(int einstellungenAuswahl) {
        Einstellungen.einstellungenAuswahl = einstellungenAuswahl;
    }

    public static void setMenu(String[] menu) {
        Einstellungen.menu = menu;
    }

    // Menüpunkte über ein Array definiert, über das später per for-Schleife iteriert wird.
    protected static void einstellungsMenueAnzeigen(){
        MenueText.ausgeben("Einstellungen");

        String[] menuePunkte = {
                "Getränke-Einstellungen ändern",
                "Neues Getränk hinzufügen",
                "Anzahl zubereiteter Getränke anzeigen",
                "Umsatz der Maschine anzeigen",
                "Füllstand Bohnenbehälter anzeigen",
                "Füllstand Milchbehälter anzeigen",
                "Reset Bezüge",
                "Zurück"
        };
        setMenu(menuePunkte);
    }

    protected static void auswahlBehandeln(GetraenkeAngebot getraenkeAngebot, Scanner consoleScanner){
        try{
            String eingabe = consoleScanner.nextLine().trim();
            if (eingabe.isEmpty()){
                System.out.print("Bitte eine Zahl eingeben!");
            }

            setEinstellungenAuswahl(Integer.parseInt(eingabe));

            switch (einstellungenAuswahl){
                case 1 -> getraenkeEinstellungenAendern();
                case 2 -> neuesGetraenkHinzufuegen(getraenkeAngebot, consoleScanner);
                case 3 -> System.out.println("Insgesamt zubereitete Getränke: " + Bezuege.anzahlAnzeigen());
                case 4 -> umsatzAnzeigen();
                case 5 -> fuellstandBohnenbehaelterAnzeigen();
                case 6 -> fuellstandMilchbehaelterAnzeigen();
                case 7 -> Bezuege.resetBezuege();
                case 8 -> System.out.println("Zurück...");
                default -> System.out.println("Bitte eine verfügbare Auswahl treffen!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void getraenkeEinstellungenAendern(){
        System.out.println("Hier können später die Getränke-Einstellungen geändert werden " +
                "(Füllmenge, Brühzeit, Preis)");
    }

    public static void neuesGetraenkHinzufuegen(GetraenkeAngebot getraenkeAngebot, Scanner consoleScanner){
        System.out.println("Hier kann später ein neues Getränk hinzugefügt werden.");
        System.out.println("Testdaten werden hinzugefügt: Testkaffee - 600 ml - 2.0 min - ja - 8.0€");
        Getraenk neuesGetraenk = new Getraenk(
                "Testkaffee",
                600,
                2.0,
                true,
                8.0);
        getraenkeAngebot.addNeuesGetraenk(neuesGetraenk);
    }

    private static void umsatzAnzeigen(){
        System.out.println("Hier wird später der an dieser Maschine gemachte Umsatz angezeigt.");
    }

    private static void fuellstandBohnenbehaelterAnzeigen(){
        // System.out.print("Name des Bohnenbehälters: ");
        System.out.println(Bohnenbehaelter.fuellstandAnzeigen(Bohnenbehaelter.name)); // Platzhalter - Feature noch nicht implementiert
    }

    private static void fuellstandMilchbehaelterAnzeigen(){
        // System.out.print("Name des Milchbehälters: ");
        System.out.println(Milchbehaelter.fuellstandAnzeigen(Milchbehaelter.name));    // Platzhalter - Feature noch nicht implementiert
    }

    public static void anzeigen(GetraenkeAngebot getraenkeAngebot, Scanner consoleScanner){
        do {
            einstellungsMenueAnzeigen();
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.print("Bitte Auswahl treffen: (1 - " + menu.length + "): ");

            auswahlBehandeln(getraenkeAngebot, consoleScanner);

        }while (einstellungenAuswahl < menu.length);
    }
}