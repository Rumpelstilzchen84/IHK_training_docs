import java.io.*;
import java.util.stream.Collectors;

/**
 * @author: Philip Kottmann
 * @Datum: 24.3.2025
 * @Inhalt: Klasse "Getränk"
 */

public class Getraenk {
    static int anzahlBezuege;
    // Fields/Attribute
    private String bezeichnung;
    private int fuellmenge;
    private double bruehzeit;
    private boolean milchschaum;
    private double preis;

    // Konstruktoren
    public Getraenk(String bezeichnung, int fuellmenge, double bruehzeit, boolean milchschaum, double preis){
        setBezeichnung(bezeichnung);
        setFuellmenge(fuellmenge);
        setBruehzeit(bruehzeit);
        setMilchschaum(milchschaum);
        setPreis(preis);
    }

    // Methoden
    //-- Getränk ausgeben
    void getraenkAusschenken(){
        anzahlBezuege++;
        //-- Progress-Bar zum Brühfortschritt
        // Bruehfortschritt bruehfortschritt = new Bruehfortschritt(bruehzeit, milchschaum);
        System.out.println(bezeichnung + " zubereitet! Bitte schön!");
        System.out.println("Füllmenge: " + fuellmenge + " ml\n" +
                "Brühzeit: " + bruehzeit + " min\n" +
                (milchschaum == false ? "Ohne" : "Mit") + " Milchschaum");
        anzahlGetraenkeSpeichern(anzahlBezuege);
    }

    //-- Anzahl zubereiteter Getränke persistent speichern (=> .txt-file)
    void anzahlGetraenkeSpeichern(int anzahlBezuege){
        try {
            BufferedWriter dateiWriter = new BufferedWriter(new FileWriter("zubereiteteGetraenke.txt"));
            dateiWriter.write(Integer.toString(anzahlBezuege));
            dateiWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: zuerst den im txt-File gespeicherten Wert abrufen und in integer umwandeln.
    // danach diesen Wert um den neuen Wert des aktuellen Aufrufs erhöhen und wieder abspeichern.
    //-- Anzahl zubereiteter Getränke abrufen
    static void anzahlGetraenkeAusgeben(){
        int anzahlGetraenke;
        try {
            BufferedReader dateiReader = new BufferedReader(new FileReader("zubereiteteGetraenke.txt"));
            dateiReader.readLine();
            String line;
            System.out.println(dateiReader);
//            while((line = dateiReader.readLine()) != null){
//                continue;
//            }
            dateiReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return (int) dateiReader;
    }



    // Getter-Methoden
    static int getAnzahlBezuege(){
        return anzahlBezuege;
    }

    String getBezeichnung(){
        return bezeichnung;
    }

    public double getPreis() {
        return preis;
    }

// Setter-Methoden

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setFuellmenge(int fuellmenge) {
        this.fuellmenge = fuellmenge;
    }

    public void setBruehzeit(double bruehzeit) {
        this.bruehzeit = bruehzeit;
    }

    public void setMilchschaum(boolean milchschaum) {
        this.milchschaum = milchschaum;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}