import java.util.Scanner;

/**
 * @author: Philip Kottmann
 * @Datum: 7.4.2025
 * @Inhalt: Einstellungen der Kaffeemaschine anzeigen und ändern
 */

public class Einstellungen {
    private static int einstellungenAuswahl;
    private static String[] menu;

    // leerer Konstruktor der verhindert, dass eine Instanz erstellt wird.
    private Einstellungen(){

    }

    public static void setEinstellungenAuswahl(int einstellungenAuswahl) {
        Einstellungen.einstellungenAuswahl = einstellungenAuswahl;
    }

    public static void setMenu(String[] menu) {
        Einstellungen.menu = menu;
    }

    protected static void einstellungsMenueAnzeigen(){
        MenueText.ausgeben("Einstellungen");

        String[] menuePunkte = {
                "Getränke-Einstellungen ändern",
                "Neues Getränk hinzufügen",
                "Anzahl zubereiteter Getränke anzeigen",
                "Umsatz der Maschine anzeigen",
                "Füllstand Bohnenbehälter anzeigen",
                "Füllstand Milchbehälter anzeigen",
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
                case 2 -> neuesGetraenkHinzufuegen();
                case 3 -> System.out.println("Insgesamt zubereitete Getränke: " +
                        getraenkeAngebot.getGetraenke().getFirst().anzahlBezuegeAuslesen());
                case 4 -> umsatzAnzeigen();
                case 5 -> fuellstandBohnenbehaelterAnzeigen();
                case 6 -> fuellstandMilchbehaelterAnzeigen();
                case 7 -> System.out.println("Zurück...");
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

    private static void neuesGetraenkHinzufuegen(){
        System.out.println("Hier kann später ein neues Getränk hinzugefügt werden.");
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