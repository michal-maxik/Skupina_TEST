public class StudyTask implements ITask {
    private String predmet;
    private int hodinCelkem;
    private int odpracovano;
    private boolean hotovo;

    public StudyTask(String predmet, int hodinCelkem) {
        this.predmet = predmet;
        this.hodinCelkem = hodinCelkem;
        this.odpracovano = 0;
        this.hotovo = false;
    }

    public void update(int noveOdpravovano, boolean isDone) {
        this.odpracovano += noveOdpravovano;
        this.hotovo = isDone;
    }

    public void display() {
        System.out.println("Studijní předmět: " + predmet + " Počet hodin: " + hodinCelkem + " Již odstudováno: " + odpracovano + " Studium hotovo?: " + hotovo);
    }

    public boolean isDone() {
        return hotovo;
    }

    public int getOdpracovano() {
        return odpracovano;
    }
}