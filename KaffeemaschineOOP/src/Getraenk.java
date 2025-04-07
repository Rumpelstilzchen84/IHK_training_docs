import javax.crypto.spec.PSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

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

    private final Path DATEI_PFAD = Path.of("zubereiteteGetraenke.txt");

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
    public void getraenkAusschenken(){
        int shots = 1;
        //-- Progress-Bar zum Brühfortschritt
        // Bruehfortschritt bruehfortschritt = new Bruehfortschritt(bruehzeit, milchschaum);
        System.out.println(bezeichnung + " zubereitet! Bitte schön!");
        System.out.println("Füllmenge: " + fuellmenge + " ml\n" +
                "Brühzeit: " + bruehzeit + " min\n" +
                (milchschaum == false ? "Ohne" : "Mit") + " Milchschaum");
        anzahlBezuegeErhoehen(shots);
    }

    private void anzahlBezuegeErhoehen(int shots) {
        setAnzahlBezuege((anzahlBezuegeAuslesen() + shots));
        anzahlbezuegeSchreiben(getAnzahlBezuege());
    }

    public int anzahlBezuegeAuslesen() {
        String anzahl = "";
        int bezuegeInDatei = 0;
        if (Files.exists(DATEI_PFAD)){
            try(BufferedReader reader = Files.newBufferedReader(DATEI_PFAD)){
                // TODO: Leeres .txt-file wird noch nicht abgefangen => NumberFormatException
                if((anzahl = reader.readLine()) != null){
                    //System.out.println("Bezüge in Datei vorhanden");
                    bezuegeInDatei = Integer.parseInt((anzahl));
                } else {
                    //System.out.println("Bezüge = 0");
                    bezuegeInDatei = 0;
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return bezuegeInDatei;
    }

    private void anzahlbezuegeSchreiben(int anzahlBezuege) {
        try (BufferedWriter writer = Files.newBufferedWriter(
                DATEI_PFAD,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING))
        {
            writer.write(String.valueOf(anzahlBezuege));
            writer.newLine();
            //System.out.println("Erfolgreich geschrieben!");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben der Bezüge");
        }
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

    public static void setAnzahlBezuege(int anzahlBezuege) {
        Getraenk.anzahlBezuege = anzahlBezuege;
    }
}