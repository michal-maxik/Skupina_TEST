public class WorkTask implements ITask {
    private String popis;
    private int hodinNutnych;
    private int odpracovano;
    private boolean hotovo;
    private String deadline;
    private int cenaZaHodinu;

    public WorkTask(String popis, int hodinNutnych, String deadline, int cenaZaHodinu) {
        this.popis = popis;
        this.hodinNutnych = hodinNutnych;
        this.deadline = deadline;
        this.cenaZaHodinu = cenaZaHodinu;
        this.odpracovano = 0;
        this.hotovo = false;
    }

    public void update(int noveOdpracovano, boolean isDone) {
        odpracovano += noveOdpracovano;
        if (odpracovano > hodinNutnych) {
            System.out.println("Upozornění: Překročil jsi počet hodin – některé nemusí být proplacené.");
        }
        hotovo = isDone;
    }

    public void display() {
        System.out.println("WorkTask: " + popis + " | Hodin: " + hodinNutnych + " | Odpracováno: " + odpracovano +
                " | Hotovo: " + hotovo + " | Deadline: " + deadline + " | Kč/h: " + cenaZaHodinu);
    }


    public boolean isDone() {
        return hotovo; }
    public int getOdpracovano() {
        return odpracovano; }
    public int getCenaZaHodinu() {
        return cenaZaHodinu; }
    public String getPopis() {
        return popis; }
}