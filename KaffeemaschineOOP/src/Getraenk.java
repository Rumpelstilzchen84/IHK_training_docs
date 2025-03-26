/**
 * @author: Philip Kottmann
 * @Datum: 24.3.2025
 * @Inhalt: Klasse "Getränk"
 */
import me.tongfei.progressbar.ProgressBar;

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

        // Progress-Bar: <= TODO
    void bruehFortschritt(double bruehzeit, boolean milchschaum){
        double schritte = (bruehzeit * 60)/0.05;
        if(milchschaum){
            schritte += 15;
        }
        schritte = (int) schritte;
        try (ProgressBar pb = new ProgressBar("Wird zubereitet", 100)) {
            for (int i = 0; i < 100; i++) {
                // Fortschritt um 1 erhöhen
                pb.step();

                // Simuliert eine Aufgabe durch eine kleine Pause
                try {
                    Thread.sleep(25); // 25 Millisekunden Pause
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