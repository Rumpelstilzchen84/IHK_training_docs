/**
 * @author: Philip Kottmann
 * @Datum: 24.3.2025
 * @Inhalt: Klasse "Getränk"
 */
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarStyle;

public class Getraenk {
    // Fields/Attribute
    private String name;
    private int fuellmenge;
    private double bruehzeit;
    private boolean milchschaum;

    static int anzahlGetraenke;
    static int anzahlBezuege;

    // Konstruktoren
    Getraenk(String name, int fuellmenge, double bruehzeit, boolean milchschaum){
        anzahlGetraenke++;

        this.name = name;
        this.fuellmenge = fuellmenge;
        this.bruehzeit = bruehzeit;
        this.milchschaum = milchschaum;
    }

    // Methoden
        // Getränk ausgeben
    void getraenkAusgeben(){
        anzahlBezuege++;
        bruehFortschritt(bruehzeit, milchschaum);
        System.out.println(name + " zubereitet! Bitte schön!");
        System.out.println("Füllmenge: " + fuellmenge + " ml\n" +
                "Brühzeit: " + bruehzeit + " min\n" +
                (milchschaum == false ? "Ohne" : "Mit") + " Milchschaum");
    }

        // Progress-Bar zum Brühfortschritt
    void bruehFortschritt(double bruehzeit, boolean milchschaum){
        double pausenberechnung = (50 * bruehzeit); // Pause [ms]
        long pause = Math.round(pausenberechnung);
        if(milchschaum){
            pause += 25;
        }
        try (ProgressBar pb = new ProgressBar("Zubereitung", 100)) {
            for (int i = 0; i < 100; i++) {
                // Fortschritt um 1 erhöhen
                pb.step();

                // Simuliert eine Aufgabe durch eine kleine Pause
                try {
                    Thread.sleep(pause); // Pause [ms]
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // GETTER-Methoden
    static int getAnzahlGetraenke(){
        return anzahlGetraenke;
    }

    static int getAnzahlBezuege(){
        return anzahlBezuege;
    }

    String getName(){
        return name;
    }
}