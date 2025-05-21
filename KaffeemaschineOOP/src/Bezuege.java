import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Bezuege {
    // static Attribute
    static int anzahlBezuege;
    private static final Path DATEI_PFAD = Path.of("zubereiteteGetraenke.txt");

    // Leerer Konstruktor, damit keine Instanz erzeugt werden kann.
    private Bezuege(){

    }

    // Getter-Methoden
    static int getAnzahlBezuege() {
        return anzahlBezuege;
    }

    public Path getDATEI_PFAD() {
        return DATEI_PFAD;
    }

    // Setter-Methoden
    private static void setAnzahlBezuege(int anzahlBezuege) {
        Bezuege.anzahlBezuege = anzahlBezuege;
    }

    public static void anzahlBezuegeErhoehen(int shots) {
        setAnzahlBezuege((anzahlAnzeigen() + shots));
        anzahlbezuegeSchreiben(getAnzahlBezuege());
    }

    private static void anzahlbezuegeSchreiben(int anzahlBezuege) {
        try (BufferedWriter writer = Files.newBufferedWriter(
                DATEI_PFAD,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING))
        {
            writer.write(String.valueOf(anzahlBezuege));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben der Bezüge");
        }
    }

    // Eigene Methoden
    public static int anzahlAnzeigen(){
        String anzahl = "";
        int bezuegeInDatei = 0;
        if (Files.exists(DATEI_PFAD)){
            try(BufferedReader reader = Files.newBufferedReader(DATEI_PFAD)){
                if((anzahl = reader.readLine()) != null){
                    bezuegeInDatei = Integer.parseInt((anzahl));
                } else {
                    bezuegeInDatei = 0;
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return bezuegeInDatei;
    }

    public static void resetBezuege(){
        setAnzahlBezuege(0);
        anzahlbezuegeSchreiben(getAnzahlBezuege());
    }
}
