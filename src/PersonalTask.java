public class PersonalTask implements ITask {
    private String popis;
    private int maxCas;
    private int odpracovano;
    private boolean hotovo;

    public PersonalTask(String popis, int maxCas) {
        this.popis = popis;
        this.maxCas = maxCas;
        this.odpracovano = 0;
        this.hotovo = false;
    }

    public void update(int noveHodiny, boolean isDone) {
        this.odpracovano += noveHodiny;
        this.hotovo = isDone;
    }

    public void display() {
        System.out.println("Osobní úkol: " + popis + ", Max: " + maxCas + ", Odpracováno: " + odpracovano + ", Hotovo: " + hotovo);
    }
    public boolean isDone() {
        return hotovo; }
    public int getOdpracovano() {
        return odpracovano; }
    public String getPopis() {
        return popis; }
}

