package JavaUebung5;

/**
 * Created by LK IT
 */
public class Bruch {

    // Zum zählen, wie viele Bruch Objekte von dieser Klasse erstellt wurden
    static int anzahlBrueche = 0;

    // Variablen, in der jedes Objekt seine Werte für Nenner und Zähler speichern kann
    private int zaheler;
    private int nenner;

    /**
     * Standart - Konstruktor der Klasse - (der OHne Parameter in den ( )  )
     */
    Bruch(){
        // ruft den Konstruktor "Bruch (int z, int n) auf
        this(0,1);
    }

    /**
     * Konstruktor mit Parameter nenner
     *
     * @param nenner
     */
    Bruch(int nenner){
        // ruft den Konstruktor Bruch (int z, int n) auf
        this(1, nenner);
    }

    /**
     * Konstruktor der Nenner und Zähler als Parameter aktzeptiert und für das neue Objekt erzeugt
     * @param z
     * @param n
     */
    Bruch (int z, int n){
        // ruft die Methode setze(z,n) auf um die Werte zu setzen
        setze(z,n);
        // erhöht die statische (Klassen Variable) vom Objekt aus, so das wir zählen können wie viele Objekte erstellt wurden
        anzahlBrueche++;
    }

    /**
     *  Gibt:  "Zähler / Nenner"  auf der Konsole aus, wenn Nenner != 1 sonst nur Nenner (als ganze Zahl)
     */
    void ausgeben(){
        System.out.println(getZaheler() + (getNenner() == 1 ? "":"/"+ getNenner()));

        /*
        * Die Ausführliche Variante zu der obigen Zeile - besser verständlich, aber mehr zu Tippen
        if(nenner == 1){
            System.out.println( zaheler );
        }
        else
        {
            System.out.println( zaheler + "/" + nenner);
        }
        */

    }

    /**
     * Kürz den Bruch in dem mittels Moodulo Operator (Rest) und einer Schleige der ggT bestimmt wird
     * Der Bruch wird dann entsprechend gekürtzt und diese Werte gesetzt
     */
    void kuerzen(){
        int hz, hn, r; // Deklaration

        hz = getZaheler();  //Wertzuweisung
        hn = getNenner();

        r  = hz % hn;  // der Rest veim Teilen von Zähler / Nenner

        while(r > 0){  // Solange wie es einen Rest git, weiter teilen
            hz  = hn;
            hn = r;
            r = hz % hn;
        }
        // neuem gekürzte Werte Zetzen
        setZaheler(getZaheler() /hn);
        setNenner(getNenner()  / hn);
    }

    /**
     * Kürzen des Bruchs und anschließende Ausgabe
     */
    void gekuerztausgeben(){
        kuerzen();      // Methoden aufruf
        ausgeben();     // Methoden aufruf

    }

    /**
     * Multipliziert den JavaUebung5.Bruch mit einem neune JavaUebung5.Bruch m
     *
     * @param m Objekt der Klasse JavaUebung5.Bruch
     */
    void multiplizieren(Bruch m){
        // mit get den Wert Holen, ausrechnen und im set wieder setzen lassen
        setZaheler(getZaheler() * m.getZaheler());
        setNenner(getNenner() * m.getNenner());

    }

    /**
     * Setzt den Zähler und nimmt für den Nenner 1 an
     * @param z
     */
    void setze(int z){
        setze(z,1);
    }

    /**
     * Setzt den Zähler auf den Wert z und den Nenner auf den Wert n
     * @param z
     * @param n
     */
    void setze(int z, int n){

        setZaheler(z);
        setNenner(n);

    }

    /**
     * Erweitert den Bruch um die Zahl a
     * @param a
     */
    void erweitern(int a){

        setZaheler( getZaheler() * a);
        setNenner( getNenner() * a);
    }

    /**
     * Gibt den Dezimalwert des Bruchs zurück
     * @return
     */
    double dezimalwert(){
        return (double) getZaheler() / getNenner();
    }

    /**
     * Gibt 0 Zurück, wenn ...
     * @return
     */
    int signum(){
        if( this.dezimalwert() == 0){
            return 0;
        }else if(this.dezimalwert() > 0){
            return 1;
        }else{
            return -1;  // kleiner 0
        }
    }

    // GET und SET Methoden - nutzt man statt immer direkt auf die Variable zu gehen, so kann man
    // z.B. immer Prüfen ob der nenner ungleich null ist um div durch 0 zu vermeiden

    public int getZaheler() {
        return zaheler;
    }

    public void setZaheler(int zaheler) {
        this.zaheler = zaheler;
    }

    public int getNenner() {
        return nenner;
    }

    public void setNenner(int nenner) {
        if(nenner==0){
            System.out.println("Fehler, der Nenner darf nicht 0 sein!");
            nenner = 1;

        }
        this.nenner = nenner;
    }
}