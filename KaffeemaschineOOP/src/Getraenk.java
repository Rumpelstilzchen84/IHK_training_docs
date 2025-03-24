/**
 * @author: Philip Kottmann
 * @Datum: 24.3.2025
 * @Inhalt: Klasse "Getränk"
 */
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
    void getraenkAusgeben(){
        anzahlBezuege++;
        System.out.println(name + " zubereitet! Bitte schön!");
        System.out.println("Füllmenge: " + fuellmenge + " ml\n" +
                "Brühzeit: " + bruehzeit + " min\n" +
                (milchschaum == false ? "Ohne" : "Mit") + " Milchschaum");
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