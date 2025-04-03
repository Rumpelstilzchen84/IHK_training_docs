/**
 * @author: Philip Kottmann
 * @Datum: 23. März 2025
 * @Inhalt: Kaffeemaschine in OOP
 */

/* TODO:
- Wert der Variablen "anzahlBezuege" persistent speichern.
- Eingezahltes Guthaben beachten, zu wenig Guthaben abfangen, Rückgeld herausgeben
 */

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class KaffeemaschineOOP {
    public static void main(String[] args) {
        GetraenkeAngebot getraenkeAngebot = new GetraenkeAngebot();

        String ueberschrift = "Kaffee-Automat";
        MenueText.ausgeben(ueberschrift);
        System.out.println(getraenkeAngebot.getAnzahlGetraenke() + " verschiedene Getränke stehen zur Auswahl");
        Trennlinie.ausgeben(MenueText.getMenueTextBreite());

        var consoleScanner = new Scanner(System.in);

        int getraenkeWunsch = 0;

        do {
            getraenkeAngebotAnzeigen(getraenkeAngebot);

            // Nutzer zur Eingabe auffordern:
            System.out.print("Bitte Auswahl treffen (1 - " + getraenkeAngebot.getAnzahlGetraenke() + ") " +
                    "oder \"" + (getraenkeAngebot.getAnzahlGetraenke() + 1) + "\" zum Ausschalten: ");

            // Eingabe prüfen und verifizieren
            try {
                String eingabe = consoleScanner.nextLine().trim(); // Ganze Zeile ohne vor- oder nachgestellte Leerzeichen einlesen
                if (eingabe.isEmpty()) { // Prüfung, ob Eingabe leer
                    System.out.println("Bitte eine Zahl eingeben.");
                    continue;
                }
                getraenkeWunsch = Integer.parseInt(eingabe);

                if (getraenkeWunsch >= 1 && getraenkeWunsch <= getraenkeAngebot.getAnzahlGetraenke()){ // valide Getränke-Auswahl
                    // Getränk zubereiten
                    getraenkeAngebot.getGetraenke().get(getraenkeWunsch - 1).getraenkAusschenken();

                    // Bisherige Bezüge an dieser Maschine ausgeben:
                    Trennlinie.ausgeben(MenueText.getMenueTextBreite());
                    System.out.println("Bisher zubereitete Getränke an dieser Maschine: " + Getraenk.getAnzahlBezuege() + " Stk.");
                    Trennlinie.ausgeben(MenueText.getMenueTextBreite());

                    System.out.println(); // Leerzeichen zur Trennung der Bestellvorgänge
                } else if (getraenkeWunsch == getraenkeAngebot.getAnzahlGetraenke() + 1) { // Ausschalten der Maschine
                    System.out.println("Kaffeeautomat wird ausgeschaltet...");
                } else {        // Fehlerhafte Eingabe
                    System.out.println("Auswahl nicht verfügbar. Bitte eine Zahl im angegebene Bereich eingeben");
                }
            } catch (NumberFormatException e) {
                // throw new RuntimeException(e);
                System.out.println("Bitte eine gültige Zahl eingeben");
            }
        } while (getraenkeWunsch != (getraenkeAngebot.getAnzahlGetraenke() + 1));
        consoleScanner.close();
    }

    private static void getraenkeAngebotAnzeigen(GetraenkeAngebot getraenkeAngebot) {
        // Definition um "double" mit zwei Dezimalstellen anzugeben
        Locale.setDefault(Locale.GERMAN);
        DecimalFormat dezimalAngabe = new DecimalFormat("##0.00");

        // Ausgabe der Getränkeauswahl
        for (int i = 0; i < getraenkeAngebot.getAnzahlGetraenke(); i++) {
            System.out.println((i+1) + ". " + getraenkeAngebot.getGetraenke().get(i).getBezeichnung() +
                    " (€ " + dezimalAngabe.format(getraenkeAngebot.getGetraenke().get(i).getPreis()) + ")");
        }
        System.out.println((getraenkeAngebot.getAnzahlGetraenke() + 1) + ". Ausschalten");
    }

}