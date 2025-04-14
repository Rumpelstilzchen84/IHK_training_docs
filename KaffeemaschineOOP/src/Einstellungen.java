import java.util.Scanner;

/**
 * @author: Philip Kottmann
 * @Datum: 7.4.2025
 * @Inhalt: Einstellungen der Kaffeemaschine anzeigen und ändern
 */

public class Einstellungen {

    Scanner consoleScanner = new Scanner(System.in);
    private int einstellungsAuswahl = 0;
    String ueberschrift = "Einstellungen";


    public Einstellungen(GetraenkeAngebot getraenkeAngebot) {    // Konstruktor
        do {
            einstellungsMenueAnzeigen();

            try{
                String eingabe = consoleScanner.nextLine().trim();
                if (eingabe.isEmpty()){
                    System.out.print("Bitte eine Zahl eingeben!");
                    continue;
                }
                einstellungsAuswahl = Integer.parseInt(eingabe);

                switch (einstellungsAuswahl){
                    case 1 -> getraenkeEinstellungenAendern();
                    case 2 -> neuesGetraenkHinzufuegen();
                    case 3 -> System.out.println("Insgesamt zubereitete Getränke: " +
                            getraenkeAngebot.getGetraenke().getFirst().anzahlBezuegeAuslesen());
                    case 4 -> umsatzAnzeigen();
                    case 5 -> System.out.println("Zurück... ");
                    default -> System.out.println("Bitte eine verfügbare Auswahl treffen!");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (einstellungsAuswahl != 5);

    }

    public void einstellungsMenueAnzeigen(){
        MenueText.ausgeben(ueberschrift);

        System.out.println("1. Getränke-Einstellungen ändern");
        System.out.println("2. Neues Getränk hinzufügen");
        System.out.println("3. Anzahl zubereiteter Getränke anzeigen");
        System.out.println("4. Umsatz der Maschine anzeigen");
        System.out.println("5. Zurück");
        System.out.print("Bitte Auswahl treffen: ");
    }

    public void getraenkeEinstellungenAendern(){
        System.out.println("Hier können später die Getränke-Einstellungen geändert werden " +
                "(Füllmenge, Brühzeit, Preis)");
    }

    public void neuesGetraenkHinzufuegen(){
        System.out.println("Hier kann später ein neues Getränk hinzugefügt werden.");
    }

    public void umsatzAnzeigen(){
        System.out.println("Hier wird später der an dieser Maschine gemachte Umsatz angezeigt.");
    }
}

/*
PK: Ideen/Gedanken/Fragen dazu:
-   Kann das Einstellungs-Menü analog dem "GetraenkeAngebot" auch über ein Interface erstellt werden?
-   Zeile 32: Wie ist die Logik hitner diesem Ausdruck?
    getraenkeAngebot.getGetraenke().getFirst().anzahlBezuegeAuslesen()
    => ich bin durch Zufall drauf gestoßen, da IntelliJ mir diese Auswahl angezeigt hat.
    Der Aufruf von "Getraenk.anzahlBezuege" (static int Variable) hat immer erst das Ergebnis aus der
    .txt-Datei angezeigt, wenn vorher einmal ein Getränk bestellt/ausegegeben wurde.
    Wo liegt da der Fehler?
 */