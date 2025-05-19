public class Fuellstand {
    private int minimum = 0;
    private int maximum = 0;

    // Konstruktor
    public Fuellstand() {

    }

    // Getter
    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }


    // Setter
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }


    // eigene Methoden
    private void fuellstandErhoehen(){

    }

    private void fuellstandVerrringern(){

    }

    public static String fuellstandAnzeigen(String behaelter){
        //System.out.println("Das ist der Füllstand des " + behaelter.getClass());
        return "Das ist der Füllstand des " + behaelter;
    }
}
