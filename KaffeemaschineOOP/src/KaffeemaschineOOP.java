import java.util.Scanner;

/**
 * @author: Philip Kottmann
 * @Datum: 23. März 2025
 * @Inhalt: Kaffeemaschine in OOP
 */

public class KaffeemaschineOOP {
    public static void main(String[] args) {
        boolean statusAuswahl = true;

        General.divider();
        System.out.println("=== Kaffee-Automat ===");
        General.divider();

        Getraenk[] getraenkeAngebot = {
                (new Getraenk("Café Crème",200, 1.0, false)),
                (new Getraenk("Espresso",50, 0.5, false)),
                (new Getraenk("Café Cortado", 60, 1., true)),
                (new Getraenk("Cappuccino", 250, 1.5, true)),
                (new Getraenk("Latte Macchiato", 300, 1.5, true))};

        var consoleScanner = new Scanner(System.in);
        int auswahl = 0;

        while (statusAuswahl) {    // Endlosschleife zur Anzeige des Menüs
            // Ausgabe der verfügbaren Getränke
            System.out.println(Getraenk.getAnzahlGetraenke() + " verschiedene Getränke stehen zur Auswahl");

            // Erstellung der Items im Menü
            for (int i = 0; i < getraenkeAngebot.length; i++) {
                System.out.println((i+1) + ". " + getraenkeAngebot[i].getName());
            }
            System.out.println("9. Ausschalten"); // Zusätzlicher Menüpunkt "Ausschalten".

            // Aufforderung, eine Auswahl zu treffen
            System.out.print("Bitte Auswahl treffen (1 - " + getraenkeAngebot.length + ") oder Ausschalten: ");

            // Abfrage der Nutzereingabe
            // var consoleScanner = new Scanner(System.in);
            // int auswahl = (consoleScanner.nextInt());
            auswahl = consoleScanner.nextInt();

            switch(auswahl){
                case 1:
                    getraenkeAngebot[auswahl-1].getraenkAusgeben();
                    break;
                case 2:
                    getraenkeAngebot[auswahl-1].getraenkAusgeben();
                    break;
                case 3:
                    getraenkeAngebot[auswahl-1].getraenkAusgeben();
                    break;
                case 4:
                    getraenkeAngebot[auswahl-1].getraenkAusgeben();
                    break;
                case 5:
                    getraenkeAngebot[auswahl-1].getraenkAusgeben();
                    break;
                case 9:
                    statusAuswahl = false;
                    break;
                default:
                    System.out.println("Getränk nicht verfügbar!");
                    break;
            }

            // Zusammenfassung:
            General.divider();
            System.out.println("Bisher zubereitete Getränke an dieser Maschine: " + Getraenk.getAnzahlBezuege() + " Stk.");
            General.divider();

        }
        consoleScanner.close();
    }
}